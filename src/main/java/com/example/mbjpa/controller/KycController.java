package com.example.mbjpa.controller;

import com.example.mbjpa.Service.KYCService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/kycs")
@RequiredArgsConstructor
public class KycController {
    private final KYCService kycService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<?> getKycByCustomerPhoneNumber(@PathVariable String phoneNumber) {
        return new ResponseEntity<>(kycService.getKycByCustomerPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @PutMapping("/{nationalCardId}")
    public ResponseEntity<?> verifyCustomerByNationalCardId(@PathVariable String nationalCardId) {
        kycService.verifyCustomerByCustomerNationalCardId(nationalCardId);
        return new ResponseEntity<>(Map.of("verified", nationalCardId), HttpStatus.OK);
    }
}