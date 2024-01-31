package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.CustomerResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;
import com.workintech.FSWEBS18D4JavaProjesi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return DtoConverter.convertToCustomerResponseList(customerRepository.findAll()) ;
    }

    @Override
    public CustomerResponse findById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            return DtoConverter.convertToCustomerResponse(optionalCustomer.get());
        }

        return null;

    }

    @Override
    public CustomerResponse save(Customer customer) {
        return DtoConverter.convertToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse remove(long id) {
        CustomerResponse willRemove = findById(id);
        customerRepository.deleteById(id);
        return willRemove;
    }
}
