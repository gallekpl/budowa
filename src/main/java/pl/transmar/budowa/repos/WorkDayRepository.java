package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.WorkDay;

import java.util.Date;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
    WorkDay findByDate(Date date);
}
