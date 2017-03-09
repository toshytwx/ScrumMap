package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.User;

/**
 * Created by User on 01.03.2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
    void updateUser(User user);
}
