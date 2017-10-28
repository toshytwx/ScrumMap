package gmail.dimon0272.WebApp.actions.user;

import gmail.dimon0272.WebApp.actions.Action;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.user.UserService;

/**
 * Created by User on 07.03.2017.
 */
public abstract class UserAction  implements Action{
    protected UserService userService;
    protected User user;

    public UserAction(UserService userService, User user){
        this.user = user;
        this.userService = userService;
    }
}
