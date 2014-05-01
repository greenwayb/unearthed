package models;

import com.avaje.ebean.annotation.Encrypted;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import util.HashHelper;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ben on 2/04/2014.
 * Lightweight User Object
 */
@Entity
//@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type")
@DiscriminatorValue("MatchUser")
public class MatchUser extends Model {

    @Id
    @GeneratedValue
    private Long id;

    @Constraints.Required(message = "The username is required")
    private String username;

    //@--Encrypted
    @Constraints.Required(message = "The password is required")
    private String password;

    @Constraints.Email(message = "email is invalid")
    private String email;

    private Date createdOn = new Date();

    private Date LastLoggedOn = new Date();


    public MatchUser(String userName, String password) {
        this.username = userName;
        setPassword(password);
    }

    public MatchUser(String username, String password, String email) {
        this.username = username;
        setPassword(password);
        this.email = email;
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
        this.password = HashHelper.createPassword(password);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
