package ru.jetlabs.ts.authprovider.v1.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jetlabs.ts.authprovider.dto.LoginRequest;
import ru.jetlabs.ts.authprovider.dto.Message;
import ru.jetlabs.ts.authprovider.dto.TokenResponse;
import ru.jetlabs.ts.authprovider.service.JwtService;
import ru.jetlabs.ts.authprovider.v1.LoginContractV1;

import java.util.Optional;

@AllArgsConstructor
@RestController("/api/v1")
public class LoginControllerV1 implements LoginContractV1 {
    private final JwtService jwtService;
    @Override
    @PostMapping("/login")
    public ResponseEntity<Message<Optional<TokenResponse>>> login(LoginRequest loginRequest) {
        /**
         *  1) Обращение на ts-user-service с попыткой залогиниться
         *      1.1)Ожидаемый ответ - статус 200 и Message с payload:
         *                                  {
         *                                      "id" = Long,
         *                                      "emailConfirmed" = boolean
         *                                   }
         *  2) Всё ок - значит выдаём токен, id, статус по подтверждению почты
         *      2.1) Не ок - действуем по ситуации
         */
        return null;
    }
}
