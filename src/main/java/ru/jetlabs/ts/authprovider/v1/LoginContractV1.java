package ru.jetlabs.ts.authprovider.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.jetlabs.ts.authprovider.dto.LoginRequest;

public interface LoginContractV1 {
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);
}
