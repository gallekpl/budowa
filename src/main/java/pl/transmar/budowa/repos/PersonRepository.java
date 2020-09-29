package pl.transmar.budowa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transmar.budowa.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
