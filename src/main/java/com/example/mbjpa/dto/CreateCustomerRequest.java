package com.example.mbjpa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateCustomerRequest(

        @NotBlank(message = "Full name is required")
        String fullName,

        @NotBlank(message = "Gender is required")
        String gender,

        String email,
        @NotBlank(message = "Phone number is required")
        String phoneNumber,
        String remark
) {
}
