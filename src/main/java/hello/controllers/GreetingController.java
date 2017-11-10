package hello.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.StreamSupport;

import hello.entities.GreetingEntity;
import hello.repository.GreetingRepository;
import hello.representations.GreetingRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@RestController
public class GreetingController {

    private GreetingRepository greetingRepository;

    @Autowired
    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping(path="/add")
    public GreetingRepresentation addGreeting(@RequestParam(value="firstName", defaultValue="First") String firstName,
                                           @RequestParam(value="lastName", defaultValue="Last") String lastName) {

        GreetingEntity saved = greetingRepository.save(new GreetingEntity(firstName, lastName));
        GreetingEntity retrieved = greetingRepository.findOne(saved.getId());

        return new GreetingRepresentation(retrieved);
    }

    @GetMapping(path="/all")
    public List<GreetingRepresentation> getAllGreetings() {

        Iterable<GreetingEntity> greetingEntities = greetingRepository.findAll();

        List<GreetingRepresentation> greetingRepresentations = StreamSupport.stream(greetingEntities.spliterator(), false)
                .map(GreetingRepresentation::new)
                .collect(toList());

        return greetingRepresentations;
    }
}