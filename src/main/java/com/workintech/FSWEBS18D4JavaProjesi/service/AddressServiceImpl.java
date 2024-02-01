package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AddressResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;
import com.workintech.FSWEBS18D4JavaProjesi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
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
            return DtoConverter.convertToAddressResponse(addressOptional.get());
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
    public AddressResponse save(Address address) {
        return DtoConverter.convertToAddressResponse(addressRepository.save(address)) ;
    }

    @Override
    public AddressResponse remove(long id) {
        AddressResponse willRemove = findById(id);
        addressRepository.deleteById(id);
        return willRemove;
    }
}
