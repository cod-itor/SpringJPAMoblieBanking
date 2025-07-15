package com.example.mbjpa.Repository;

import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.domain.KYC;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KYCRepository extends CrudRepository<KYC,Integer> {
    Optional<KYC> findByNationalCardId(String nationalCard);
    Optional <KYC> findByCustomer(Customer customer);
}
