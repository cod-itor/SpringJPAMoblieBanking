package com.example.mbjpa.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer_segment")
public class CustomerSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer CustomerSegmentId;

    private String segmentName;

    private String benefit;

    private Boolean is_deleted;

    @OneToMany(mappedBy = " customerSegment")
    private List<Customer> customers;
}