package ru.jetlabs.ts.authprovider.client;

import java.time.LocalDateTime;

public record UserResponseForm(
    Long id,
    String firstName,
    String lastName,
    String middleName,
    String email,
    boolean emailVerified,
    String passportSeries,
    String passportNumber,
    String phone,
    boolean phoneVerified,
    LocalDateTime createdAt
) {
}