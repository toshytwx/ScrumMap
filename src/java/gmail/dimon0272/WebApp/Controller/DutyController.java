package gmail.dimon0272.WebApp.Controller;

import gmail.dimon0272.WebApp.actions.AddDutyAction;
import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.tools.DateConverter;
import gmail.dimon0272.WebApp.tools.DurationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by User on 04.03.2017.
 */
@Controller
public class DutyController {
    @Autowired
    private DutyDao dutyDao;

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
        new AddDutyAction(duty,dutyDao).execute();
        return "welcome";
    }
}
