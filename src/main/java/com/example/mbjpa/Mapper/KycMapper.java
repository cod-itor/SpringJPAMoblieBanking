package com.example.mbjpa.Mapper;

import com.example.mbjpa.domain.KYC;
import com.example.mbjpa.dto.KYC.KycResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {
        CustomerMapper.class,
})
public interface KycMapper {
    @Mapping(source = "customer", target = "customer")
    KycResponse toKycResponse(KYC kyc);
}
