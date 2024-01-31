package com.workintech.FSWEBS18D4JavaProjesi.repository;

import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
