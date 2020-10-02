package pl.transmar.budowa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name="Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PersonID", unique = true)
    private long personId;
    @NotNull
    @Column(name="LastName", nullable = false)
    private String lastName;
    @NotNull
    @Column(name="FirstName", nullable = false)
    private String firstName;
    @NotNull
    @Column(name="Role", nullable = false)
    private String role;


    public Person() {
    }

    public Person(String lastName, String firstName, String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
