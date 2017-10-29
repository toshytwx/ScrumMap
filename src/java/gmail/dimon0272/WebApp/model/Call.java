package gmail.dimon0272.WebApp.model;

import javax.persistence.*;

/**
 * Created by User on 29.10.2017.
 */
@javax.persistence.Entity
@Table (name = "calls")
public class Call {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User phoneOwner;

    @Column (name = "caller_name")
    private String caller;

    public Call(String phoneNumber, User phoneOwner, String caller) {
        this.phoneNumber = phoneNumber;
        this.phoneOwner = phoneOwner;
        this.caller = caller;
    }

    public Call() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getPhoneOwner() {
        return phoneOwner;
    }

    public void setPhoneOwner(User phoneOwner) {
        this.phoneOwner = phoneOwner;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }
}
