package com.example.mbjpa.dto;

public record UpdateCustomerRequest(
        String fullName,
        String gender,
        String remark

) {
}
