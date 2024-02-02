package com.workintech.FSWEBS18D4JavaProjesi.controller;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.CustomerResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;
import com.workintech.FSWEBS18D4JavaProjesi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerResponse findById(Long id){
        return customerService.findById(id);
    }

    @PostMapping("/customers")
    public CustomerResponse save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/customers/{id}")
    public CustomerResponse update(@PathVariable Long id,@RequestBody Customer customer){
        Customer updatedCustomer = customerService.findByIdCustomer(id);

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setSalary(customer.getSalary());
        updatedCustomer.setEmail(customer.getEmail());

        return DtoConverter.convertToCustomerResponse(updatedCustomer);
    }
    @DeleteMapping("/customers/{id}")
    public CustomerResponse delete(Long id){
        return customerService.remove(id);
    }








}
