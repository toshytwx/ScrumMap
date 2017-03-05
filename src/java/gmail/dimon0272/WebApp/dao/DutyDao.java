package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Duty;

import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
public interface DutyDao {
    void add (Duty duty);
    void delete (Duty duty);
    List <Duty> userDutyList(Long userId);
    Duty findByDutyId(Long id);
}
