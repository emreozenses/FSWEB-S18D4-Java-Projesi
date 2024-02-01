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

    public static AccountResponse convertToAccountResponse (Account account){
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

    public static List<AccountResponse> convertToAccountResponseList (List<Account> accountList){

        List<AccountResponse> accountResponseList = new ArrayList<>();

        accountList.forEach(account -> {
            accountResponseList.add(new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount()));
        });
        return accountResponseList;

    }

    public static CustomerResponse convertToCustomerResponse (Customer customer){
        return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getSalary(),
                new AddressResponse(customer.getAddress().getId(),customer.getAddress().getStreet(),customer.getAddress().getNo(),customer.getAddress().getCity(),customer.getAddress().getCountry(),customer.getAddress().getDescription()),
                convertToAccountResponseList(customer.getAccountList()));
    }

    public static List<CustomerResponse> convertToCustomerResponseList (List<Customer> customerList){

        List<CustomerResponse> customerResponseList = new ArrayList<>();

        customerList.forEach(customer -> {
            customerResponseList.add(new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getSalary(),new AddressResponse(customer.getAddress().getId(),customer.getAddress().getStreet(),customer.getAddress().getNo(),customer.getAddress().getCity(),customer.getAddress().getCountry(),customer.getAddress().getDescription()),convertToAccountResponseList(customer.getAccountList())));
        });
        return customerResponseList;

    }

    public static AddressResponse convertToAddressResponse (Address address){
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
