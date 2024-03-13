package semicolonafrica.group7capstoneproject.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserRegisterRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String phoneNumber;
    private boolean termsAccepted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dateOfBirth;
    private String pin;
    private String confirmPin;
    private String bvn;
}
