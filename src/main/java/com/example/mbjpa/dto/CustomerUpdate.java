package com.example.mbjpa.dto;

public record CustomerUpdate(
        String fullName,
        String email,
        String phoneNumber,
        String remark,
        Boolean isDeleted
) {
}
