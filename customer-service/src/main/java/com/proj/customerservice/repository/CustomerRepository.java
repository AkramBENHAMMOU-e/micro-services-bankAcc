package com.proj.customerservice.repository;

import com.proj.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
