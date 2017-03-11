package gmail.dimon0272.WebApp.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Created by User on 03.03.2017.
 */
@Entity
@Table(name = "duties")
public class Duty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dutyname")
    private String dutyName;

    @Transient
    private Duration dutyDuration;

    @Column(name = "dutyduration")
    private Long dutyDurationInMillis;

    @Column(name = "dutystartdate")
    private Date dutyStartDate;

    @Column(name = "dutydescription")
    private String dutyDescription;

    @Column(name = "dutyimportance")
    private String dutyImportance;

    @Column(name = "dutystatus")
    private String dutyStatus;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Duty() {
    }

    public Duty(String dutyName, Duration dutyDuration, Date dutyStartDate, String dutyDescription, String dutyImportance, String dutyStatus) {
        this.dutyName = dutyName;
        this.dutyDuration = dutyDuration;
        if(dutyDuration != null)
            this.dutyDurationInMillis = dutyDuration.toMillis();
        this.dutyStartDate = dutyStartDate;
        this.dutyDescription = dutyDescription;
        this.dutyImportance = dutyImportance;
        this.dutyStatus = dutyStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Duration getDutyDuration() {
        Duration result = null;
        if (dutyDurationInMillis != null)
            result = Duration.ofMillis(dutyDurationInMillis);
        return result;
    }

    public void setDutyDuration(Duration dutyDuration) {
        {
            if (dutyDuration != null)
                dutyDurationInMillis = dutyDuration.toMillis();
        }
    }

    public Long getDutyDurationInMillis() {
        return dutyDurationInMillis;
    }

    public void setDutyDurationInMillis(Long dutyDurationInMillis) {
        this.dutyDurationInMillis = dutyDurationInMillis;
    }

    public Date getDutyStartDate() {
        return dutyStartDate;
    }

    public void setDutyStartDate(Date dutyStartDate) {
        this.dutyStartDate = dutyStartDate;
    }

    public String getDutyDescription() {
        return dutyDescription;
    }

    public void setDutyDescription(String dutyDescription) {
        this.dutyDescription = dutyDescription;
    }

    public String getDutyImportance() {
        return dutyImportance;
    }

    public void setDutyImportance(String dutyImportance) {
        this.dutyImportance = dutyImportance;
    }

    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
    }
}
