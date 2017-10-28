package gmail.dimon0272.WebApp.actions.user;

import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.user.UserService;

/**
 * Created by User on 07.03.2017.
 */
public class UpdateUserAction extends UserAction {
    public UpdateUserAction(UserService userService, User user) {
        super(userService, user);
    }

    @Override
    public void execute() {
        userService.updateUser(user);
    }
}
