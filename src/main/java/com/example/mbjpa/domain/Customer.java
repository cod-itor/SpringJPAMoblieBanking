package com.example.mbjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // when i put entities the POJO become entities meaning that it all of the product map out
public class Customer {
    @Id
    private Integer id;
    private String fullName; // the (a) next to the side of the number bar is (altribute)
    private String gender;
    private String email;
    private String phoneNumber;
    private String remark;
    private Boolean isDeleted;
}
