package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.WorkDay;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
}
