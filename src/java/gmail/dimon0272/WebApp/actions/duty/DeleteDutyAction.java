package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.service.DutyService;

/**
 * Created by Dmitrii Antonkin on 28.10.2017.
 */
public class DeleteDutyAction extends DutyAction {

    public DeleteDutyAction(DutyService dutyService, Duty duty) {
        super(dutyService, duty);
    }

    @Override
    public void execute(){
        dutyService.delete(duty);
    }
}
