package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts {
    @Id

    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private Integer id;

    @Column( name = "account_Number", nullable = false, unique = true, length = 20)

    private String actNo;

    @Column( name = "account_Type", nullable = false, length = 50)

    private String actType;

    @Column(nullable = false)

    private Double balance;

    @Column(nullable = false)

    private Boolean isDeleted;

    @ManyToOne // one customer can be owned by many acc
    @JoinColumn(name = "cust_id") //change the column costume name into what i want
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;




}
