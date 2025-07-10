package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String checkingAccount;
    private String savingAccount;
    private String depositAccount;
    private String businessAccount;
    private String jointAccount;
    private String studentAccount;

@OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private List<Accounts> accounts;
}
