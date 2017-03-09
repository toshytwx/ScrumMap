package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;

/**
 * Created by User on 04.03.2017.
 */
public class AddDutyAction extends DutyAction {
    private User user;
    public AddDutyAction(User user, Duty duty, DutyDao dutyDao) {
        super(duty, dutyDao);
        this.user = user;
    }

    @Override
    public void execute() {
        duty.setUser(user);
        dutyDao.add(duty);
    }
}
