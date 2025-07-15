package com.example.mbjpa.Service;

import com.example.mbjpa.dto.KYC.KycResponse;

public interface KYCService {
    KycResponse getKycByCustomerPhoneNumber(String phoneNumber);
    void verifyCustomerByCustomerNationalCardId(String nationalCardId);

}
