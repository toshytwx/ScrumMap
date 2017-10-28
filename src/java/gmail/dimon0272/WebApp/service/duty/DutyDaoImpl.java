package gmail.dimon0272.WebApp.service.duty;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import gmail.dimon0272.WebApp.service.security.SecurityService;
import gmail.dimon0272.WebApp.service.user.UserService;
import gmail.dimon0272.WebApp.tools.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
@Repository
public class DutyDaoImpl implements DutyDao {
    private Query query;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Duty findByDutyId(Long id) {
        query = entityManager.createQuery("SELECT c FROM Duty c where c.id = :id", Duty.class);
        query.setParameter("id", id);
        return (Duty) query.getSingleResult();
    }

    @Transactional
    @Override
    public void updateDuty(Duty dutyToUpgrade) {
        entityManager.merge(dutyToUpgrade);
    }

    @Transactional
    @Override
    public void add(Duty duty) {
        entityManager.merge(duty);
    }

    @Transactional
    @Override
    public void delete(Duty duty) {
        entityManager.remove(entityManager.contains(duty) ? duty : entityManager.merge(duty));
    }


    @Override
    public List<Duty> getUserDutyList(User user) {
        query = entityManager.createQuery("SELECT DISTINCT c FROM Duty c INNER JOIN c.user g WHERE g.id = :user1", Duty.class);
            query.setParameter("user1", user.getId());
        return processingDutyList((List<Duty>) query.getResultList());
        }
    @Override
    public List<Duty> getUserDutyByStatus(User user, String status) {
        List <Duty> list = getUserDutyList(user);
        List <Duty> newList = new ArrayList<>();
        for (Duty duty: list){
            if(duty.getDutyStatus().equals(status)){
                newList.add(duty);
            }
        }
        return newList;
    }
    @Transactional
    @Override
    public List<Duty> processingDutyList(List<Duty> list) {
        for (Duty duty: list) {
            duty.setDutyStartDate(DateConverter.convertToPattern(duty.getDutyStartDate().toString()));
        }
        return list;
    }
}
