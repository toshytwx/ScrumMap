package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.actions.Action;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.service.DutyService;

/**
 * Created by User on 04.03.2017.
 */
public abstract class DutyAction implements Action {
    protected Duty duty;
    protected DutyService dutyService;

    public DutyAction(DutyService dutyService, Duty duty) {
        this.duty = duty;
        this.dutyService = dutyService;
    }

    public DutyAction(DutyService dutyService) {
        this.dutyService = dutyService;
    }
}
