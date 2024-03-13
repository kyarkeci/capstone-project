package semicolonafrica.group7capstoneproject.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolonafrica.group7capstoneproject.dtos.AccountInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private int statusCode;
    private boolean success;
    private String message;
    private AccountInfo accountInfo;
}
