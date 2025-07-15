package com.example.mbjpa.dto.KYC;

import com.example.mbjpa.dto.CustomerResponse;

public record KycResponse(
        String nationalCardId,
        CustomerResponse customer,
        Boolean isVerified
) {
}
