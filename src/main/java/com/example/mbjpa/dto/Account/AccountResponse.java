package com.example.mbjpa.dto.Account;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccountResponse(
        String actNo,
        String actType,
        BigDecimal balance,
        LocalDateTime createdAt
) {
}