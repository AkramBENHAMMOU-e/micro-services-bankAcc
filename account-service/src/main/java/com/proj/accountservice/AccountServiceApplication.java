package com.proj.accountservice;

import com.proj.accountservice.entities.BankAccount;
import com.proj.accountservice.enums.AccountType;
import com.proj.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args ->
        {
          List<BankAccount> bankAccounts = List.of(
            BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(12000)
                    .currency("MAD")
                    .type(AccountType.SAVING_ACCOUNT)
                    .createdAt(LocalDate.now())
                    .customerId(1L)
                    .build(),
            BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(15000)
                    .currency("MAD")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .createdAt(LocalDate.now())
                    .customerId(2L)
                    .build()
          );
          bankAccountRepository.saveAll(bankAccounts);
        };
    }
}
