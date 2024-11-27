package ru.jetlabs.ts.authprovider.dto;

import ru.jetlabs.ts.authprovider.constants.MessageStatus;

public record Message<T>(
        MessageStatus status,
        String text,
        T payload
) {}
