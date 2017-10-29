package gmail.dimon0272.WebApp.сontroller;

import gmail.dimon0272.WebApp.model.Call;
import gmail.dimon0272.WebApp.service.call.CallService;
import gmail.dimon0272.WebApp.service.security.SecurityService;
import gmail.dimon0272.WebApp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 29.10.2017.
 */
@Controller
public class CallController {
    @Autowired
    private CallService callService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/addcall", method = RequestMethod.POST)
    public String addDuty(Model model) {
        Call call = new Call("123",  userService.findByUsername(securityService.findLoggedInUsername()), "123");
        callService.add(call);
        return "redirect:/welcome";
    }
}
