package ru.jetlabs.ts.authprovider.dto;

public record TokenResponse(
        String token,
        Long userId,
        boolean emailConfirmed
) {
}
