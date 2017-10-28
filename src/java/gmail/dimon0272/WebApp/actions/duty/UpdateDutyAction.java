package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.service.DutyService;

/**
 * Created by User on 28.10.2017.
 */
public class UpdateDutyAction extends DutyAction {

    public UpdateDutyAction(DutyService dutyService, Duty duty) {
        super(dutyService, duty);
    }

    @Override
    public void execute() {
        dutyService.updateDuty(duty);
    }
}
