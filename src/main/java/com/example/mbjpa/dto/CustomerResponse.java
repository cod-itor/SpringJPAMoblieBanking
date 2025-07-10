package com.example.mbjpa.dto;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String uuid,
        String fullName,
        String gender,
        String email,
        String phoneNumber,
        String remark
) {
}
