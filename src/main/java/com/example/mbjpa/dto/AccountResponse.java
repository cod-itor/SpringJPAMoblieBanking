package com.example.mbjpa.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountResponse(
        String actNo,
        String actType,
        BigDecimal balance
) {
}