package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 01.03.2017.
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
