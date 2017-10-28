package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.duty.DutyService;

/**
 * Created by User on 04.03.2017.
 */
public class AddDutyAction extends DutyAction {
    private User user;
    public AddDutyAction(User user, Duty duty, DutyService dutyService) {
        super(dutyService, duty);
        this.user = user;
    }

    @Override
    public void execute() {
        duty.setUser(user);
        dutyService.add(duty);
    }
}
