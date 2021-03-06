package gmail.dimon0272.WebApp.сontroller;

import gmail.dimon0272.WebApp.actions.duty.AddDutyAction;
import gmail.dimon0272.WebApp.actions.duty.DeleteDutyAction;
import gmail.dimon0272.WebApp.actions.duty.FindDutyAction;
import gmail.dimon0272.WebApp.actions.duty.UpdateDutyAction;
import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.dao.UserDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.duty.DutyService;
import gmail.dimon0272.WebApp.service.security.SecurityService;
import gmail.dimon0272.WebApp.service.user.UserService;
import gmail.dimon0272.WebApp.tools.DateConverter;
import gmail.dimon0272.WebApp.tools.DurationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
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
                DateConverter.convertToDateTime(dutystartdate),
                dutydescription,
                dutyimportance,
                dutystatus);
        User user = userService.findByUsername(securityService.findLoggedInUsername());
        new AddDutyAction(user,duty,dutyService).execute();
        List<Duty> dutyList = dutyService.userDutyList(user);
        dutyList.add(duty);
        user.setUserListOfDuties(dutyList);
        return "redirect:/welcome";
    }

    @RequestMapping(value={"/welcome", "/allDuties"}, method = RequestMethod.GET)
    public String showDutyList(Model model) {
        List<Duty> list = dutyService.userDutyList(userService.findByUsername(securityService.findLoggedInUsername()));
        for (Duty duty : list) {
            if (duty.getDutyStatus().equals("Performs") &&
                    (duty.getDutyStartDate().getTime() + duty.getDutyDurationInMillis()) < new Date().getTime()) {
                duty.setDutyStatus("Failed");
                new UpdateDutyAction(dutyService, duty).execute();
            }
        }
        model.addAttribute("list", list);
        return "welcome";
    }

    @RequestMapping(value="/doneDuties", method = RequestMethod.GET)
    public String showDoneDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Done"));
        return "welcome";
    }
    @RequestMapping(value="/progressDuties", method = RequestMethod.GET)
    public String showInProgressDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Performs"));
        return "welcome";
    }
    @RequestMapping(value="/failedDuties", method = RequestMethod.GET)
    public String showFailedDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Failed"));
        return "welcome";
    }

    @RequestMapping(value="/determiningDuties", method = RequestMethod.GET)
    public String showDeterminingDutyList(Model model){
        model.addAttribute("list",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Determining"));
        return "welcome";
    }
    @RequestMapping(value="/deleteduty", method = RequestMethod.POST)
    public String deleteDuty(Model model, @RequestParam String dutyid){
        Duty dutyToDelete = dutyService.findByDutyId(Long.parseLong(dutyid));
        new DeleteDutyAction(dutyService, dutyToDelete).execute();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/details/{dutyid}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDutyDetails(Model model, @PathVariable(value ="dutyid") Long id){
        Duty currentDuty = new FindDutyAction(dutyService).execute(id);
        model.addAttribute("dutyId", currentDuty.getId());
        model.addAttribute("dutyName",currentDuty.getDutyName());
        model.addAttribute("dutyStartDate",currentDuty.getDateInStringFormat());
        model.addAttribute("dutyDescription", currentDuty.getDutyDescription());
        model.addAttribute("dutyImportance", currentDuty.getDutyImportance());
        model.addAttribute("dutyStatus", currentDuty.getDutyStatus());
        model.addAttribute("dutyDuration", DurationConverter.toString(currentDuty.getDutyDurationInMillis()));
        return "dutyDetails";
    }

    @RequestMapping(value="/details/{dutyId}/editduty", method = {RequestMethod.POST, RequestMethod.GET})
    public String editDuty(Model model, @PathVariable(value ="dutyId") Long id,
                           @RequestParam String dutyid,
                           @RequestParam String dutyname,
                           @RequestParam String dutyduration,
                           @RequestParam String dutystartdate,
                           @RequestParam String dutydescription,
                           @RequestParam String dutyimportance,
                           @RequestParam String dutystatus){
        Duty dutyToUpgrade = new FindDutyAction(dutyService).execute(id);
        dutyToUpgrade.setDutyDescription(dutydescription);
        dutyToUpgrade.setDutyDurationInMillis(DurationConverter.toDuration(dutyduration).toMillis());
        dutyToUpgrade.setDutyImportance(dutyimportance);
        dutyToUpgrade.setDutyName(dutyname);
        dutyToUpgrade.setDutyStatus(dutystatus);
        dutyToUpgrade.setDutyStartDate(DateConverter.convertStringToDate(dutystartdate));
        new UpdateDutyAction(dutyService, dutyToUpgrade).execute();
        return "redirect:/welcome";
    }

    @RequestMapping(value="/map", method = RequestMethod.GET)
    public String showMap(Model model){
        model.addAttribute("determiningDutiesList",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Determining"));
        model.addAttribute("doneDutiesList",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Done"));
        model.addAttribute("performingDutiesList",dutyService.userDutyByStatus(userService.findByUsername(securityService.findLoggedInUsername()), "Performs"));
        return "map";
    }

    @RequestMapping(value = "/changetodetermining", method = RequestMethod.POST)
    public String changeDutyStatusToDetermining(Model model, @RequestParam String dutyid){
        Duty dutyToUpgrade = new FindDutyAction(dutyService).execute(Long.parseLong(dutyid));
        dutyToUpgrade.setDutyStatus("Determining");
        new UpdateDutyAction(dutyService, dutyToUpgrade).execute();
        return "redirect:/map";
    }

    @RequestMapping(value = "/changetoperform", method = RequestMethod.POST)
    public String changeDutyStatusToPerform(Model model, @RequestParam String dutyid){
        Duty dutyToUpgrade = new FindDutyAction(dutyService).execute(Long.parseLong(dutyid));
        dutyToUpgrade.setDutyStatus("Performs");
        new UpdateDutyAction(dutyService, dutyToUpgrade).execute();
        return "redirect:/map";
    }

    @RequestMapping(value = "/changetodone", method = RequestMethod.POST)
    public String changeDutyStatusToDone(Model model, @RequestParam String dutyid){
        Duty dutyToUpgrade = new FindDutyAction(dutyService).execute(Long.parseLong(dutyid));
        dutyToUpgrade.setDutyStatus("Done");
        new UpdateDutyAction(dutyService, dutyToUpgrade).execute();
        return "redirect:/map";
    }

}
