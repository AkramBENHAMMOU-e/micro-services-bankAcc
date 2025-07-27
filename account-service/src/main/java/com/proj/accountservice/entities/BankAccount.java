package com.proj.accountservice.entities;

import com.proj.accountservice.enums.AccountType;
import com.proj.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long  customerId;

}
