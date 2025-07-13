package com.example.mbjpa.Repository;

import com.example.mbjpa.domain.Accounts;
import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.dto.AccountResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    boolean existsByActNo(String actNo);


    Optional<Accounts> findByActNo(String actNo);
}
