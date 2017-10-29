package gmail.dimon0272.WebApp.service.call;

import gmail.dimon0272.WebApp.dao.CallDao;
import gmail.dimon0272.WebApp.model.Call;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by User on 29.10.2017.
 */
@Repository
public class CallDaoImpl implements CallDao {
    private Query query;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(Call call) {
        entityManager.merge(call);
    }

    @Transactional
    @Override
    public void delete(Call call) {
        entityManager.remove(entityManager.contains(call) ? call : entityManager.merge(call));
    }

    @Transactional
    @Override
    public void update(Call call) {
        entityManager.merge(call);
    }

    @Override
    public Call findByCallId(Long id) {
        query = entityManager.createQuery("SELECT c FROM Call c where c.id = :id", Call.class);
        query.setParameter("id", id);
        return (Call) query.getSingleResult();
    }
}
