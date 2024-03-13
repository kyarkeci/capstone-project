package semicolonafrica.group7capstoneproject.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
    private boolean loginWithEmail;
    private String deviceId;
}
