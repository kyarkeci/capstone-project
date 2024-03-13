package semicolonafrica.group7capstoneproject.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Account  {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String accountNumber;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String address;
    private String stateOfOrigin;
    private String gender;
    private Date dateOfBirth;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role_id", nullable = false)
    private Set<Role> roles = new HashSet<>();

}
