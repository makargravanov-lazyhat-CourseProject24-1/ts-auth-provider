package ru.jetlabs.ts.authprovider.v1.api;

import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jetlabs.ts.authprovider.client.UserFindForm;
import ru.jetlabs.ts.authprovider.client.UserResponseForm;
import ru.jetlabs.ts.authprovider.client.UserServiceClient;
import ru.jetlabs.ts.authprovider.dto.LoginRequest;
import ru.jetlabs.ts.authprovider.dto.TokenResponse;
import ru.jetlabs.ts.authprovider.service.JwtService;
import ru.jetlabs.ts.authprovider.v1.LoginContractV1;

import java.util.Objects;

@RestController
@RequestMapping("/ts-auth-provider/api/v1")
public class LoginControllerV1 implements LoginContractV1 {
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;

    public LoginControllerV1(JwtService jwtService, UserServiceClient userServiceClient) {
        this.jwtService = jwtService;
        this.userServiceClient = userServiceClient;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            ResponseEntity<UserResponseForm> response =
                    userServiceClient.getByEmailAndPassword(new UserFindForm(loginRequest.email()
                            ,loginRequest.password()));
            if (response.getStatusCode().is2xxSuccessful()){
                return ResponseEntity.ok(new TokenResponse(
                        jwtService.generateToken(Objects.requireNonNull(response.getBody()).id()),
                        response.getBody().id(),
                        response.getBody().emailVerified()
                ));
            } else {
                return response;
            }
        }catch (FeignException e){
            return ResponseEntity.notFound().build();
        }
    }
}
