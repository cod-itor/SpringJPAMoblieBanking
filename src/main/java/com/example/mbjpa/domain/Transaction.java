package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false,unique = true)
    private String accType;
    @Column(nullable = false,unique = true)

    private String sender;

    @Column(nullable = false,unique = true)

    private String receiver;

    @Column(nullable = false,unique = true)

    private BigDecimal amount;

    @Column(columnDefinition = "TEXT")

    private String remark;

    @ManyToOne
    private Accounts accounts;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;


}
