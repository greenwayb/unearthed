package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ben on 8/04/2014.
 * Have an audit, for example of when users log in
 */
@Entity
public class Audit {

    @Id
    @GeneratedValue
    private String id;

    private AuditEvent event;

    private String username;

    private Date eventDateTime;

    /**
     * Other info about the event, ie for payment, the amount. For mesage who it was to...
     */
    private String info;

    public Audit(AuditEvent event, String username, Date eventDateTime, String info) {
        this.event = event;
        this.username = username;
        this.eventDateTime = eventDateTime;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AuditEvent getEvent() {
        return event;
    }

    public void setEvent(AuditEvent event) {
        this.event = event;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id='" + id + '\'' +
                ", event=" + event +
                ", username='" + username + '\'' +
                ", eventDateTime=" + eventDateTime +
                ", info='" + info + '\'' +
                '}';
    }
}
