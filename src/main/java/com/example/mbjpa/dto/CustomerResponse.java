package com.example.mbjpa.dto;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String fullName,
        String gender,
        String phoneNumber,
        String remark
) {
}
