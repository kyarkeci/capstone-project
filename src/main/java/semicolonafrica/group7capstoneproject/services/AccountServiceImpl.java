package semicolonafrica.group7capstoneproject.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import semicolonafrica.group7capstoneproject.data.models.Account;
import semicolonafrica.group7capstoneproject.data.models.Role;
import semicolonafrica.group7capstoneproject.data.repositories.AccountRepository;
import semicolonafrica.group7capstoneproject.dtos.AccountInfo;
import semicolonafrica.group7capstoneproject.dtos.requests.*;
import semicolonafrica.group7capstoneproject.dtos.responses.AccountResponse;
import semicolonafrica.group7capstoneproject.security.jwt.JwtUtils;
import semicolonafrica.group7capstoneproject.utils.AccountUtils;

import java.util.Collections;
import java.util.Map;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    @Override
    public ResponseEntity<?> registration(RegisterRequest registerRequest) {
        return performHttpRequest("https://tapper.somee.com/auth/register", registerRequest);
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        return performHttpRequest("https://tapper.somee.com/auth/login", loginRequest);
    }

    @Override
    public ResponseEntity<?> completeRegistration(CompleteRegistrationRequest completeRegistrationRequest) {
        return performHttpRequest("https://tapper.somee.com/auth/complete-registration", completeRegistrationRequest);
    }

    @Override
    public ResponseEntity<?> setupPin(PinSetUpRequest pinSetUpRequest) {
        return performHttpRequest("https://tapper.somee.com/auth/setup-pin", pinSetUpRequest);
    }

    @Override
    public ResponseEntity<?> addAndBvnValidation(BvnValidationRequest bvnValidationRequest) {
        return performHttpRequest("https://tapper.somee.com/auth/add-and-validate-bvn", bvnValidationRequest);
    }


    public AccountResponse basicRegistration(UserRegisterRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())){
            return errorResponse(AccountUtils.ACCOUNT_EXISTS_CODE,AccountUtils.ACCOUNT_EXISTS_MESSAGE);
        }
        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())){
            return errorResponse(AccountUtils.PASSWORD_NOT_MATCH_CODE,AccountUtils.PASSWORD_MISMATCH_MESSAGE);
        }
        if (!userRequest.isTermsAccepted()){
            return errorResponse(AccountUtils.TERMS_NOT_ACCEPTED_CODE,AccountUtils.TERMS_NOT_ACCEPTED_MESSAGE);
        }
        Account user = Account.builder()
                .roles(Collections.singleton(Role.ROLE_USER))
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        Account savedUser = userRepository.save(user);

        return AccountResponse.builder()
                .statusCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .success(true)
                .message(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .email(savedUser.getEmail())
                        .build())
                .build();

    }

    public AccountResponse fullRegistration(UserRegisterRequest userRequest) {
        Account user = Account.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .gender(userRequest.getGender())
                .dateOfBirth(userRequest.getDateOfBirth())
                .build();
        return AccountResponse.builder()
                .statusCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .success(true)
                .message(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }


    public AccountResponse pinSetUp(UserRegisterRequest userRequest) {
        if (!userRequest.getPin().equals(userRequest.getConfirmPin()))
            return errorResponse(AccountUtils.PASSWORD_NOT_MATCH_CODE,AccountUtils.PASSWORD_MISMATCH_MESSAGE);

        return AccountResponse.builder()
                .statusCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .success(true)
                .message(AccountUtils.PIN_SET_UP_SUCCESSFULLY_MESSAGE)
                .build();
    }

    public AccountResponse bvnValidation(UserRegisterRequest userRequest) {
        // to be updated with bvn verification api
        if (userRequest.getBvn() == null){
            return errorResponse(AccountUtils.BVN_NOT_VERIFIED_CODE,AccountUtils.BVN_NOT_VERIFIED_MESSAGE);
        }
        return AccountResponse.builder()
                .statusCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .success(true)
                .message(AccountUtils.PIN_SET_UP_SUCCESSFULLY_MESSAGE)
                .build();
    }
    private AccountResponse errorResponse(int statusCode, String message) {
        return AccountResponse.builder()
                .statusCode(statusCode)
                .success(false)
                .message(message)
                .accountInfo(null)
                .build();
    }

    private ResponseEntity<?> performHttpRequest(String url, Object requestBody) {
        try {
            String requestBodyString = objectMapper.writeValueAsString(requestBody);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(requestBodyString, headers);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);

            Map<String, Object> responseMap = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, Object>>() {});

            return ResponseEntity.ok(responseMap);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Error processing JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RestClientException e) {
            return new ResponseEntity<>("Error in the remote server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
