package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
