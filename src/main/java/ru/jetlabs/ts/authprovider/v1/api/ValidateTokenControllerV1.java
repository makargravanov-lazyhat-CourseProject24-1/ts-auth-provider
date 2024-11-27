package ru.jetlabs.ts.authprovider.v1.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jetlabs.ts.authprovider.dto.Message;
import ru.jetlabs.ts.authprovider.dto.TokenRequest;
import ru.jetlabs.ts.authprovider.dto.TokenResponse;
import ru.jetlabs.ts.authprovider.service.JwtService;
import ru.jetlabs.ts.authprovider.v1.ValidateTokenContractV1;

import java.util.Optional;

@AllArgsConstructor
@RestController("/api/v1")
public class ValidateTokenControllerV1 implements ValidateTokenContractV1 {
    private final JwtService jwtService;
    @Override
    @PostMapping("/validate")
    public ResponseEntity<Message<Optional<TokenResponse>>> validateToken(TokenRequest tokenRequest) {
        
        return null;
    }
}
