package com.workintech.FSWEBS18D4JavaProjesi.converter;

import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AddressResponse;
import com.workintech.FSWEBS18D4JavaProjesi.dto.CustomerResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static AccountResponse convertToAccountResponse (Account account,long id){
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),new CustomerResponse(account.getCustomer().getId(),account.getCustomer().getEmail(),account.getCustomer().getSalary()));
    }

    public static List<AccountResponse> convertToAccountResponseList (List<Account> accountList){

        List<AccountResponse> accountResponseList = new ArrayList<>();

        accountList.forEach(account -> {
            accountResponseList.add(new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),new CustomerResponse(account.getCustomer().getId(),account.getCustomer().getEmail(),account.getCustomer().getSalary())));
        });
        return accountResponseList;

    }

    public static CustomerResponse convertToCustomerResponse (Customer customer){
        return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());

    }

    public static List<CustomerResponse> convertToCustomerResponseList (List<Customer> customerList){

        List<CustomerResponse> customerResponseList = new ArrayList<>();

        customerList.forEach(customer -> {
            customerResponseList.add(new CustomerResponse(customer.getId(),  customer.getEmail(), customer.getSalary()));
        });
        return customerResponseList;

    }

    public static AddressResponse convertToAddressResponse (Address address,long id){
        return new AddressResponse(address.getId(), address.getStreet(), address.getNo(), address.getCity(), address.getCountry(), address.getDescription());
    }

    public static List<AddressResponse> convertToAddressResponseList (List<Address> addressList){

        List<AddressResponse> addressResponseList = new ArrayList<>();

        addressList.forEach(address -> {
            addressResponseList.add(new AddressResponse(address.getId(),address.getStreet(), address.getNo(), address.getCity(), address.getCountry(), address.getDescription()));
        });
        return addressResponseList;
    }
}
