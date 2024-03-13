package semicolonafrica.group7capstoneproject.data.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
public class AccountDetails {
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String address;
    private String stateOfOrigin;
}
