package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.actions.Action;
import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;

/**
 * Created by User on 04.03.2017.
 */
public abstract class DutyAction implements Action {
    protected Duty duty;
    protected DutyDao dutyDao;

    public DutyAction(Duty duty, DutyDao dutyDao) {
        this.duty = duty;
        this.dutyDao = dutyDao;
    }
}
