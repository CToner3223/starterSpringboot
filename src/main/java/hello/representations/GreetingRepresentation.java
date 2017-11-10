package hello.representations;

import hello.entities.GreetingEntity;

public class GreetingRepresentation {

    private final long id;
    private final String firstName;
    private final String lastName;


    public GreetingRepresentation(GreetingEntity retrieved) {
        id = retrieved.getId();
        firstName = retrieved.getFirstName();
        lastName = retrieved.getLastName();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
