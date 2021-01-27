package pl.transmar.budowa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity (name="WorkDay")
@NoArgsConstructor
@Getter
@Setter
public class WorkDay {
    @Id
    @Column(name="Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @OneToMany(mappedBy = "workDay", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;
    @Column(name="HoursWorked")
    private int hoursWorked;

    public WorkDay(Date date, int hoursWorked) {
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return getDate().toString();
    }
}


