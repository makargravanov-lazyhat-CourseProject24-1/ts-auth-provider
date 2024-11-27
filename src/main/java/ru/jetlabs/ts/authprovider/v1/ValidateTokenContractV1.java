package ru.jetlabs.ts.authprovider.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.jetlabs.ts.authprovider.dto.TokenRequest;

public interface ValidateTokenContractV1 {
    ResponseEntity<?> validateToken(@RequestBody TokenRequest tokenRequest);
}
