package com.example.mbjpa.dto.Account;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateAccountRequest(
        @NotBlank(message = "Account type is required")
        String actType,
        @NotBlank(message ="Balance is required")
        BigDecimal balance,
        LocalDateTime updateAt

) {
}
