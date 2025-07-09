package com.example.mbjpa.Repository;

import com.example.mbjpa.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
}
