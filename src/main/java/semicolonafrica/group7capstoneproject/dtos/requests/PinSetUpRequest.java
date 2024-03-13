package semicolonafrica.group7capstoneproject.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PinSetUpRequest {
    private String pin;
    private String confirmPin;
}
