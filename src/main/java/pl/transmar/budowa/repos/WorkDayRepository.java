package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.Person;
import pl.transmar.budowa.entities.Task;
import pl.transmar.budowa.entities.WorkDay;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
    WorkDay findByDate(Date date);

    @Query(value = "SELECT SUM(hoursWorked) FROM WorkDay w WHERE :task MEMBER OF w.tasks") //for learning
    int totalHours(@Param("task") Task task);

    @Query(value = "SELECT t FROM Tasks t WHERE :person MEMBER OF t.persons") //for learning purposes
    List<Task> findTasksWithSpecifiedPerson(@Param("person") Person person);


}
