package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String uuid= UUID.randomUUID().toString();

    @Column(unique = true, nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "accountType")
    private Accounts accounts;
}
