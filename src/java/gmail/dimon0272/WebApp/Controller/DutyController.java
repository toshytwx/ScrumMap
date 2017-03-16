package gmail.dimon0272.WebApp.Controller;

import gmail.dimon0272.WebApp.actions.duty.AddDutyAction;
import gmail.dimon0272.WebApp.actions.user.UpdateUserAction;
import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.dao.UserDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.DutyService;
import gmail.dimon0272.WebApp.service.SecurityService;
import gmail.dimon0272.WebApp.service.UserService;
import gmail.dimon0272.WebApp.tools.DateConverter;
import gmail.dimon0272.WebApp.tools.DurationConverter;
import gmail.dimon0272.WebApp.tools.HibernateProxyInitialization;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 04.03.2017.
 */
@Controller
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @Autowired
    private DutyDao dutyDao;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value ="/addduty", method = RequestMethod.POST)
    public String addDuty(Model model, @RequestParam String dutyname,
                          @RequestParam String dutyduration,
                          @RequestParam String dutystartdate,
                          @RequestParam String dutydescription,
                          @RequestParam String dutyimportance,
                          @RequestParam String dutystatus){
        Duty duty = new Duty(dutyname, DurationConverter.toDuration(dutyduration),
                DateConverter.convertStringToDate(dutystartdate),
                dutydescription,
                dutyimportance,
                dutystatus);
        User user = userService.findByUsername(securityService.findLoggedInUsername());
        new AddDutyAction(user,duty,dutyDao).execute();
        List<Duty> dutyList = dutyService.userDutyList(user);
        dutyList.add(duty);
        user.setUserListOfDuties(dutyList);
        return "redirect:/welcome";
    }

    @RequestMapping(value={"/welcome", "/allDuties"}, method = RequestMethod.GET)
    public String showDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyList(userService.findByUsername(securityService.findLoggedInUsername())));
        return "welcome";
    }
    @RequestMapping(value="/doneDuties", method = RequestMethod.GET)
    public String showDoneDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "done"));
        return "welcome";
    }
    @RequestMapping(value="/progressDuties", method = RequestMethod.GET)
    public String showInProgressDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "inprogress"));
        return "welcome";
    }
    @RequestMapping(value="/editduty", method = {RequestMethod.POST, RequestMethod.GET})
    public String editDuty(Model model,
                           @RequestParam String dutyid,
                           @RequestParam String dutyname,
                           @RequestParam String dutyduration,
                           @RequestParam String dutystartdate,
                           @RequestParam String dutydescription,
                           @RequestParam String dutyimportance,
                           @RequestParam String dutystatus){
        Duty dutyToUpgrade = dutyService.findByDutyId(Long.parseLong(dutyid));
        dutyToUpgrade.setDutyDescription(dutydescription);
        dutyToUpgrade.setDutyDurationInMillis(DurationConverter.toDuration(dutyduration).toMillis());
        dutyToUpgrade.setDutyImportance(dutyimportance);
        dutyToUpgrade.setDutyName(dutyname);
        dutyToUpgrade.setDutyStatus(dutystatus);
        dutyToUpgrade.setDutyStartDate(DateConverter.convertStringToDate(dutystartdate));
        dutyService.updateDuty(dutyToUpgrade);
        return "redirect:/welcome";
    }
    @RequestMapping(value="/deleteduty", method = RequestMethod.POST)
    public String deleteDuty(Model model, @RequestParam String dutyid){
        Duty dutyToDelete = dutyService.findByDutyId(Long.parseLong(dutyid));
        dutyService.delete(dutyToDelete);
        return "redirect:/welcome";
    }
}
