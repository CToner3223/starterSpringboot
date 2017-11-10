package application.representations;

import application.entities.UserEntity;

public class UserRepresentation {

    private final long id;
    private final String firstName;
    private final String lastName;


    public UserRepresentation(UserEntity retrieved) {
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
