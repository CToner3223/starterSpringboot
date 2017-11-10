package application.entities;


import javax.persistence.*;

@Entity
@Table(name = "greetings")
public class UserEntity {

    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private UserEntity() {}

    public UserEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}