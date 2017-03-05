package gmail.dimon0272.WebApp.actions;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;

/**
 * Created by User on 04.03.2017.
 */
public class AddDutyAction extends DutyAction{

    public AddDutyAction(Duty duty, DutyDao dutyDao) {
        super(duty, dutyDao);
    }

    @Override
    public void execute() {
        dutyDao.add(duty);
    }
}
