package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "customers")
@Entity // when i put entities the POJO become entities meaning that it all of the product map out
public class Customer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false)

    private String fullName;// the (a) next to the side of the number bar is (altribute)

    @Column(length = 15)

    private String gender;

    @Column(unique = true)

    private String email;

    @Column(unique = true)

    private String phoneNumber;

    @Column(columnDefinition = "TEXT")

    private String remark;

    @Column(nullable = false)

    private Boolean isDeleted;

    @OneToMany(mappedBy = "customer") //many acc can be owned by one customer
    private List<Accounts> accounts;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private KYC kyc;
}

/**
 * HOME
 */