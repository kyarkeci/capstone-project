package semicolonafrica.group7capstoneproject.services;

import org.springframework.http.ResponseEntity;
import semicolonafrica.group7capstoneproject.dtos.requests.*;
import semicolonafrica.group7capstoneproject.dtos.responses.AccountResponse;

public interface AccountService {
    ResponseEntity<?> registration(RegisterRequest registerRequest);
    ResponseEntity<?> login(LoginRequest loginRequest);
    ResponseEntity<?> completeRegistration(CompleteRegistrationRequest completeRegistrationRequest);
    ResponseEntity<?> setupPin(PinSetUpRequest pinSetUpRequest);
    ResponseEntity<?> addAndBvnValidation(BvnValidationRequest bvnValidationRequest);

    //UserResponse getUserBy(Long id) throws AccountNotFoundException;

}
