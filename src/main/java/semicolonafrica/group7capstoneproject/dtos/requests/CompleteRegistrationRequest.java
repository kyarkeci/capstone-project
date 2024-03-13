package semicolonafrica.group7capstoneproject.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompleteRegistrationRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;

}
