package models;

import org.h2.engine.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * A Person Extends a User with a few more details
 */
@Entity
@DiscriminatorValue("MatchUser")
public class Person extends MatchUser {

   /* @Id is on parent class
    @GeneratedValue
    private String id;*/

    private String firstName;
    private String lastName;

    private Gender gender = Gender.UNSPECIFIED;

    private String description;

    public Person(String username, String password, String firstName, String lastName) {
        super(username,password);
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                '}';
    }
}
