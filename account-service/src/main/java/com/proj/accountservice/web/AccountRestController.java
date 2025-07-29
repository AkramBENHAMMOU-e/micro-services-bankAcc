package com.proj.accountservice.web;

import com.proj.accountservice.clients.CustomerRestClient;
import com.proj.accountservice.entities.BankAccount;
import com.proj.accountservice.model.Customer;
import com.proj.accountservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

@GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts.forEach(bankAccount ->
        {
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        });
        return bankAccounts;
    }
@GetMapping("accounts/{id}")
   public BankAccount bankAccountById(@PathVariable String id){
    BankAccount bankAccount = bankAccountRepository.findById(id).get();
    Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
    bankAccount.setCustomer( customer );
    return bankAccount;
   }
}
