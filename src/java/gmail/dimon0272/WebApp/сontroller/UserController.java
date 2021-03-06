package gmail.dimon0272.WebApp.сontroller;

import gmail.dimon0272.WebApp.actions.user.AddUserAction;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.security.SecurityService;
import gmail.dimon0272.WebApp.service.user.UserService;
import gmail.dimon0272.WebApp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 02.03.2017.
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method= RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "registration";
        }
        new AddUserAction(userService, userForm).execute();

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if(error!=null){
            model.addAttribute("error", "Username or password is incorrect");
        }

        if(logout!=null){
            model.addAttribute("message", "Logged out successfully!");
        }

        return "login";
    }

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String start(Model model){
        return "login";
    }
}
