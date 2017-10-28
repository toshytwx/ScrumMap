package gmail.dimon0272.WebApp.service.security;

/**
 * Created by User on 01.03.2017.
 */
public interface SecurityService  {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
