package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AddressResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();

    AddressResponse findById(long id);

    AddressResponse saveId(Address address, long id);

    AddressResponse remove(long id);

    Address findByIdAddress (long id);
}
