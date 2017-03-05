package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
@Repository
public class DutyDaoImpl implements DutyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Duty findByDutyId(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void add(Duty duty) {
        entityManager.persist(duty); }

    @Override
    public void delete(Duty duty) {
        entityManager.remove(duty);
    }

    @Override
    public List<Duty> userDutyList(Long userId) {
        return null;
    }
}
