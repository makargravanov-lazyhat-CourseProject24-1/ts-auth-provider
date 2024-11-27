package ru.jetlabs.ts.authprovider.client;

public record UserFindForm(
        String email,
        String password
) {}