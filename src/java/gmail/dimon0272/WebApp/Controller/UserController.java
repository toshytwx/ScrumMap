package gmail.dimon0272.WebApp.Controller;

import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.SecurityService;
import gmail.dimon0272.WebApp.service.UserService;
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
        userService.save(userForm);

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
