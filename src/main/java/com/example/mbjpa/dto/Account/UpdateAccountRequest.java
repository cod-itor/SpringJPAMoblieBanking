package com.example.mbjpa.dto.Account;

import java.math.BigDecimal;

public record UpdateAccountRequest(
        String actType,
        BigDecimal balance

) {
}
