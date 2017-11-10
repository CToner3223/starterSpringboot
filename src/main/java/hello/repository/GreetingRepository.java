package hello.repository;

import hello.entities.GreetingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GreetingRepository extends CrudRepository<GreetingEntity, Long> {

    GreetingEntity findByFirstName(String firstName);

    List<GreetingEntity> findByLastName(String lastName);
}
