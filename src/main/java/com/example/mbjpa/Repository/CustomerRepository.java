package com.example.mbjpa.Repository;

import com.example.mbjpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByIsDeletedFalse();

    //JPQL
    @Modifying
    @Query(value = """
UPDATE Customer c SET c.isDeleted = TRUE
WHERE c.phoneNumber = :phoneNumber
""")
    void disableByPhoneNumber(String phoneNumber);



@Query(value = """
SELECT  EXISTS(SELECT c FROM Customer c WHERE c.phoneNumber = ?1)
""")
    boolean isExistByPhoneNumber(String phoneNumber);

     // Derived Query Method

    boolean existsByPhoneNumber(String phoneNumber);


    boolean existsByEmail(String email);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Optional<Customer> findByPhoneNumberAndIsDeletedFalse(String phoneNumber);

}
