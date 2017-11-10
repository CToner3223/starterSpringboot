package application.repository;

import application.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByFirstName(String firstName);

    List<UserEntity> findByLastName(String lastName);
}
