package com.example.mbjpa.dto;

public record DeleteCustomerRequest(
        String fullName,
        String email,
        String phoneNumber,
        String remark,
        Boolean isDeleted
) {
}
