package pl.transmar.budowa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
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



    public Person(String lastName, String firstName, String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
