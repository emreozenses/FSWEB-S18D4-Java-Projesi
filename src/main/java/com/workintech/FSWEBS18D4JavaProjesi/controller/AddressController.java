package com.workintech.FSWEBS18D4JavaProjesi.controller;

import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AddressResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;
import com.workintech.FSWEBS18D4JavaProjesi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/workintech")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/address/{id}")
    public AddressResponse findById(@PathVariable long id){
        return addressService.findById(id);
    }

    @PostMapping("/address/{customerId}")
    public AddressResponse save(@RequestBody Address address,@PathVariable long customerId){
        return addressService.saveId(address,customerId);
    }

    @PutMapping("/address/{id}")
    public AddressResponse update(@PathVariable long id ,@RequestBody Address address){
         Address foundAddress = addressService.findByIdAddress(id);

         foundAddress.setStreet(address.getStreet());
         foundAddress.setNo(address.getNo());
         foundAddress.setCity(address.getCity());
         foundAddress.setCountry(address.getCountry());
         foundAddress.setDescription(address.getDescription());

         return addressService.saveId(foundAddress,id);
    }
    @DeleteMapping("/address/{id}")
    public AddressResponse delete(@PathVariable long id){
        return addressService.remove(id);
    }





}
