package ru.jetlabs.ts.authprovider.dto;

public record TokenRequest(
        String token,
        boolean needEmailConfirm
) {
}
