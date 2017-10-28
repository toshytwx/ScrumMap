package gmail.dimon0272.WebApp.actions.user;

import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.UserService;

/**
 * Created by User on 28.10.2017.
 */
public class AddUserAction extends UserAction {

    public AddUserAction(UserService userService, User user) {
        super(userService,user);
    }

    @Override
    public void execute() {
        userService.save(user);
    }
}
