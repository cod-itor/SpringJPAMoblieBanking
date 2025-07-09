package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String payment;
    private String transfer;
    private String withdrawal;
    private String deposit;

    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
