package ru.jetlabs.ts.authprovider.dto;

public record LoginRequest(
        String email,
        String password
) {}
