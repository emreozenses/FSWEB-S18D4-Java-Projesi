package com.workintech.FSWEBS18D4JavaProjesi.controller;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Address;
import com.workintech.FSWEBS18D4JavaProjesi.service.AccountService;
import com.workintech.FSWEBS18D4JavaProjesi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/workintech")
public class AccountController {

    private CustomerService customerService;

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService,CustomerService customerService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountResponse findById(@PathVariable long id){
        return accountService.findById(id);
    }

    @PostMapping("/accounts/{customerId}")
    public AccountResponse save(@RequestBody Account account,@PathVariable long customerId){
        return accountService.saveId(account,customerId);
    }

    @PutMapping("/accounts/{id}")
    public AccountResponse update(@PathVariable long id,@RequestBody Account account){
        Account foundAccount = accountService.findByIdAccount(id);

        foundAccount.setAccountName(account.getAccountName());;
        foundAccount.setMoneyAmount(account.getMoneyAmount());


        return accountService.saveId(foundAccount,id);

    }
    @DeleteMapping("/accounts/{id}")
    public AccountResponse delete(@PathVariable long id){
        return accountService.remove(id);
    }
}
