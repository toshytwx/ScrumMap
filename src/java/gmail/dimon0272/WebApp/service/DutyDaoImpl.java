package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.model.Duty;
import gmail.dimon0272.WebApp.model.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
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
        return null;
    }

    @Transactional
    @Override
    public void add(Duty duty) { entityManager.persist(duty); }

    @Transactional
    @Override
    public void delete(Duty duty) {
        entityManager.remove(duty);
    }


    @Override
    public List<Duty> getUserDutyList(User user) {
        query = entityManager.createQuery("SELECT DISTINCT c FROM Duty c INNER JOIN c.user g WHERE g.id = :user1", Duty.class);
            query.setParameter("user1", user.getId());
        return (List<Duty>) query.getResultList();
        }
}
