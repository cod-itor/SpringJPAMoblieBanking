package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts {
    @Id

    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private Integer id;

    @Column( name = "account_Number", nullable = false)

    private String actNo;

    @Column( name = "account_Type", nullable = false)

    private String actType;

    @Column(nullable = false, precision = 19, scale = 4)

    private BigDecimal balance;

    @Column(nullable = false)

    private Boolean isDeleted;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne // one customer can be owned by many acc
    @JoinColumn(name = "customer_id") //change the column costume name into what i want
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "account_type_id")
//    private AccountType accountType;
    @ManyToOne()
    private CustomerSegment customerSegment;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> sentTransaction;

    @OneToMany
    private List<Transaction> receivedTransaction;



}
