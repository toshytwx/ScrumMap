package gmail.dimon0272.WebApp.actions.duty;

import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.service.duty.DutyService;

/**
 * Created by User on 28.10.2017.
 */
public class FindDutyAction extends DutyAction {

    public FindDutyAction(DutyService dutyService, Duty duty) {
        super(dutyService,duty);
    }

    public FindDutyAction(DutyService dutyService) {
        super(dutyService);
    }

    @Override
    public void execute() {}

    public Duty execute(Long id) {
       return dutyService.findByDutyId(id);
    }
}
