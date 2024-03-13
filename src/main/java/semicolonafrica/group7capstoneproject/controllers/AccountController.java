package semicolonafrica.group7capstoneproject.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import semicolonafrica.group7capstoneproject.dtos.requests.*;
import semicolonafrica.group7capstoneproject.dtos.responses.AccountResponse;
import semicolonafrica.group7capstoneproject.dtos.responses.LoginResponse;
import semicolonafrica.group7capstoneproject.services.AccountService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        return accountService.registration(registerRequest);
    }

    @PostMapping("/completeRegistration")
    public ResponseEntity<?> completeRegistration(@RequestBody CompleteRegistrationRequest registerRequest) {
        return accountService.completeRegistration(registerRequest);
    }

    @PostMapping("/setupPin")
    public ResponseEntity<?> setupPin(@RequestBody PinSetUpRequest pinSetUpRequest) {
        return accountService.setupPin(pinSetUpRequest);
    }

    @PostMapping("/addAndBvnValidation")
    public ResponseEntity<?> addAndBvnValidation(@RequestBody BvnValidationRequest bvnValidationRequest) {
        return accountService.addAndBvnValidation(bvnValidationRequest);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest);
    }
}
