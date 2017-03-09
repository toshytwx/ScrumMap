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

        return "welcome";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String showDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyList(userService.findByUsername(securityService.findLoggedInUsername())));
        return "welcome";
    }
}
