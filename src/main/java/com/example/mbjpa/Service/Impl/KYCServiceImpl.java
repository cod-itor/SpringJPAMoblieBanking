package com.example.mbjpa.Service.Impl;

import com.example.mbjpa.Mapper.KycMapper;
import com.example.mbjpa.Repository.CustomerRepository;
import com.example.mbjpa.Repository.KYCRepository;
import com.example.mbjpa.Service.KYCService;
import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.domain.KYC;
import com.example.mbjpa.dto.KYC.KycResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@AllArgsConstructor
@Service
public class KYCServiceImpl implements KYCService {
    private final CustomerRepository customerRepository;
    private final KYCRepository kycRepository;
    private final KycMapper kycMapper;


    @Override
    public KycResponse getKycByCustomerPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Phone Number Not Found")
        );
        KYC kyc = kycRepository.findByCustomer(customer).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found")
        );
        return kycMapper.toKycResponse(kyc);
    }

    @Override
    public void verifyCustomerByCustomerNationalCardId(String nationalCardId) {
        KYC kyc = kycRepository.findByNationalCardId(nationalCardId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"National Card Not Found")
        );
        kyc.setIsVerified(true);
        kycRepository.save(kyc);
    }
}
