package semicolonafrica.group7capstoneproject.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String phoneNumber;
    private boolean termsAccepted;
    private String password;
    private String confirmPassword;
}

//{
//  "email": "string",
//  "phoneNumber": "string",
//  "termsAccepted": true,
//  "password": "string",
//  "confirmPassword": "string"
//}
