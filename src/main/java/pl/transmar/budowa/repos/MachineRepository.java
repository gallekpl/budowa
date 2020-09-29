package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
}
