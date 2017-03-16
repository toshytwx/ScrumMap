package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    DutyDao dutyDao;

    @Override
    public void add(Duty duty) {
        dutyDao.add(duty);
    }

    @Override
    public void delete(Duty duty) {
        dutyDao.delete(duty);
    }

    @Override
    public List<Duty> userDutyList(User user) {
       return dutyDao.getUserDutyList(user);
    }

    @Override
    public List<Duty> userDutyByStatus(User user, String status) {
        return dutyDao.getUserDutyByStatus(user, status);
    }

    @Override
    public Duty findByDutyId(Long id) {
        return dutyDao.findByDutyId(id);
    }

    @Override
    public void updateDuty(Duty dutyToUpgrade) {
        dutyDao.updateDuty(dutyToUpgrade);
    }
}
