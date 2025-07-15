package com.example.mbjpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class KYC {
    @Id

    private Integer id;

    private String nationalCardId;

    private Boolean isVerified;

    private Boolean isDeleted;

    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
