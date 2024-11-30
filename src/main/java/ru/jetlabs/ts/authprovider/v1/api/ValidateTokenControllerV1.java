package ru.jetlabs.ts.authprovider.v1.api;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jetlabs.ts.authprovider.client.UserResponseForm;
import ru.jetlabs.ts.authprovider.client.UserServiceClient;
import ru.jetlabs.ts.authprovider.dto.TokenRequest;
import ru.jetlabs.ts.authprovider.dto.TokenResponse;
import ru.jetlabs.ts.authprovider.service.JwtService;
import ru.jetlabs.ts.authprovider.v1.ValidateTokenContractV1;

import java.util.Objects;

@RestController
@RequestMapping("/ts-auth-provider/api/v1")
public class ValidateTokenControllerV1 implements ValidateTokenContractV1 {
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;

    public ValidateTokenControllerV1(JwtService jwtService, UserServiceClient userServiceClient) {
        this.jwtService = jwtService;
        this.userServiceClient = userServiceClient;
    }

    @Override
    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestBody TokenRequest tokenRequest) {
        Long id;
        try {
            id = jwtService.validateToken(tokenRequest.token());
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }

        if(tokenRequest.needEmailConfirm()){
            try {
            ResponseEntity<UserResponseForm> response =
                    userServiceClient.getById(id);

                if (response.getStatusCode().is2xxSuccessful()){
                    return ResponseEntity.ok(new TokenResponse(
                            jwtService.generateToken(Objects.requireNonNull(response.getBody()).id()),
                            response.getBody().id(),
                            response.getBody().emailVerified()
                    ));
                } else {
                    return ResponseEntity.status(403).build();
                }
            }catch (FeignException e){
                if(e.status()==500){
                    return ResponseEntity.status(502).build();
                }
                return ResponseEntity.status(403).build();
            }
        }else {
            return ResponseEntity.ok(new TokenResponse(
                    jwtService.generateToken(id),
                    id,
                    false
            ));
        }

    }
}
