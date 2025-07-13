package com.example.mbjpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateAccountRequest(
        @NotBlank(message = "Account type is required")
        String actType,
        @NotBlank(message ="Balance is required")
        String balance

) {
}
