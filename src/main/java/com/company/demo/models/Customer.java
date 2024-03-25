package com.company.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer_tb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "cust_name", nullable = false, length = 100)
    @NotNull(message = "Full name cannot be missing")
    private String customer_name;

    @Column(name = "phone_no", nullable = false, length = 11, unique = true)
    @NotNull(message = "Phone number cannot be missing")
    private String phoneNo;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Email address cannot be missing")
    @Email
    private String email;

    @Column(name = "emp_address", nullable = false, length = 100)
    private String address;
}
