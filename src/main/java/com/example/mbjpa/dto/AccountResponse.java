package com.example.mbjpa.dto;

import lombok.Builder;

@Builder
public record AccountResponse(
        String actNo,
        String actType,
        Double balance
) {
}