package com.example.mbjpa.dto;

import java.math.BigDecimal;

public record UpdateAccountRequest(
        String actType,
        BigDecimal balance
) {
}
