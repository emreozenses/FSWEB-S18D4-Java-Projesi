package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AddressResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;
import com.workintech.FSWEBS18D4JavaProjesi.repository.AddressRepository;
import com.workintech.FSWEBS18D4JavaProjesi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository,CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponse> findAll() {
        return DtoConverter.convertToAddressResponseList(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return DtoConverter.convertToAddressResponse(addressOptional.get(),id);
        }
        //TODO Exception handling must be done
        return null;
    }



    public Address findByIdAddress (long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return addressOptional.get();
        }
        //TODO Exception handling must be done
        return null;
    }

    @Override
    public AddressResponse saveId(Address address, long id) {
        Customer foundCustomer = customerRepository.findById(id).get();
        if(foundCustomer != null){
            foundCustomer.setAddress(address);
            address.setCustomer(foundCustomer);
            addressRepository.save(address);
        }
        else {
            throw new RuntimeException("no customer found");
        }
        //TODO Exception handling must be done
        return DtoConverter.convertToAddressResponse(address,id);

    }

    @Override
    public AddressResponse remove(long id) {
        AddressResponse willRemove = findById(id);
        addressRepository.deleteById(id);
        return willRemove;
    }
}
