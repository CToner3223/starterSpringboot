package application.controllers;

import java.util.List;
import java.util.stream.StreamSupport;

import application.entities.UserEntity;
import application.repository.UserRepository;
import application.representations.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/add")
    public UserRepresentation addGreeting(@RequestParam(value="firstName", defaultValue="First") String firstName,
                                          @RequestParam(value="lastName", defaultValue="Last") String lastName) {

        UserEntity saved = userRepository.save(new UserEntity(firstName, lastName));
        UserEntity retrieved = userRepository.findOne(saved.getId());

        return new UserRepresentation(retrieved);
    }

    @GetMapping(path="/all")
    public List<UserRepresentation> getAllUsers() {

        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserRepresentation> userRepresentations = StreamSupport.stream(userEntities.spliterator(), false)
                .map(UserRepresentation::new)
                .collect(toList());

        return userRepresentations;
    }
}