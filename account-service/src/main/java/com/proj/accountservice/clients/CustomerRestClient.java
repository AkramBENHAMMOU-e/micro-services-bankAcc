package com.proj.accountservice.clients;

import com.proj.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService" ,fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    default  Customer getDefaultCustomer(Long id, Exception exception){

        return  Customer.builder().id(id).firstName("Not available").lastName("Not available").build();
    }

    @CircuitBreaker(name = "customerService"  ,fallbackMethod = "getAllCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default  List<Customer> getAllCustomers(Long id, Exception exception){
        return  List.of();
    }
}
