package pl.transmar.budowa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity (name="WorkDay")
@NoArgsConstructor
@Getter
@Setter
public class WorkDay {
    @Id
    @Column(name="Date")
    private Date date;
    @OneToMany
    @Column(name="Task")
    private List<Task> tasks;
    @Column(name="HoursWorked")
    private int hoursWorked;

    public WorkDay(Date date, int hoursWorked) {
        this.date = date;
        this.hoursWorked = hoursWorked;
    }
}


