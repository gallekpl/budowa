package pl.transmar.budowa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity (name="Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TaskID")
    private long taskId;
    @Column(name="Machines")
    @OneToMany
    private List<Machine> machines = new ArrayList<>();
    @Column(name="Persons")
    @OneToMany
    private List<Person> persons = new ArrayList<>();
    @Column(name="Description")
    private String description;
    @Column(name="Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Task(List<Machine> machines, List<Person> persons, String description, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        this.machines = machines;
        this.persons = persons;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return description;
    }
}
