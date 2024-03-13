package semicolonafrica.group7capstoneproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userReference;
    private boolean isAccountActivated;
    private boolean isAccountActive;
    private boolean isPinSetUp;
    private boolean isBvnValidated;
    private String accessToken;
    private String refreshToken;
    private int loginAttempt;
    private String publicKey;
}
