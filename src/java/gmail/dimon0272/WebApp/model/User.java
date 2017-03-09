package gmail.dimon0272.WebApp.model;

import gmail.dimon0272.WebApp.dao.DutyDao;
import gmail.dimon0272.WebApp.service.DutyDaoImpl;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 01.03.2017.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Duty> userListOfDuties = new ArrayList<Duty>();

    @Transient
    @Autowired
    DutyDao dutyDao;

    public List<Duty> getUserListOfDuties(User user) {
        return dutyDao.getUserDutyList(user);
    }

    public void setUserListOfDuties(List<Duty> userListOfDuties) {
        this.userListOfDuties = userListOfDuties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
