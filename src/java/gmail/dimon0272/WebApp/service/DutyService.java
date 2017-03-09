package gmail.dimon0272.WebApp.service;


import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */

public interface DutyService {
    void add (Duty duty);
    void delete (Duty duty);
    List<Duty> userDutyList(User user);
    Duty findByDutyId(Long id);
}
