package pl.transmar.budowa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    @ManyToMany
    @JoinColumn(name = "FKMachineID")
    private List<Machine> machines = new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "FKPersonID")
    private List<Person> persons = new ArrayList<>();
    @Column(name="Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "Date")
    private WorkDay workDay;


    public Task(List<Machine> machines, List<Person> persons, String description, WorkDay workDay){
        this.machines = machines;
        this.persons = persons;
        this.description = description;
        this.workDay = workDay;
    }

    @Override
    public String toString() {
        return description;
    }
}
