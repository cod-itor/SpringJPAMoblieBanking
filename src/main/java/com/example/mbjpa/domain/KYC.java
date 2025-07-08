package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KYC {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String nationalCardId;

    private Boolean isVerified;

    private Boolean isDeleted;

    @OneToOne(mappedBy = "kyc")
    @MapsId
    @JoinColumn(name = "cust_id")
    private Customer customer;

}
