package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.dto.CustomerResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerResponse findById(long id);

    CustomerResponse save (Customer customer);

    CustomerResponse remove (long id);
}
