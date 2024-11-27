package ru.jetlabs.ts.authprovider.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.jetlabs.ts.authprovider.dto.LoginRequest;
import ru.jetlabs.ts.authprovider.dto.Message;
import ru.jetlabs.ts.authprovider.dto.TokenResponse;

import java.util.Optional;

public interface LoginContractV1 {
    ResponseEntity<Message<Optional<TokenResponse>>> login(@RequestBody LoginRequest loginRequest);
}
