package gmail.dimon0272.WebApp.tools;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by User on 09.03.2017.
 */
public class HibernateProxyInitialization {
    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
