package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Customer;
import com.workintech.FSWEBS18D4JavaProjesi.repository.AccountRepository;
import com.workintech.FSWEBS18D4JavaProjesi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private CustomerRepository customerRepository;

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<AccountResponse> findAll() {
        return DtoConverter.convertToAccountResponseList(accountRepository.findAll());
    }

    @Override
    public AccountResponse findById(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()){
            return DtoConverter.convertToAccountResponse(accountOptional.get(),id);
        }
        //TODO Exception handling must be done
        return null;
    }

    @Override
    public AccountResponse saveId(Account account, long id) {
        Customer foundCustomer = customerRepository.findById(id).get();
        if(foundCustomer != null){
            foundCustomer.getAccountList().add(account);
            account.setCustomer(foundCustomer);
            accountRepository.save(account);
        }
        else {
            throw new RuntimeException("no customer found");
        }
        //TODO Exception handling must be done
        return DtoConverter.convertToAccountResponse(account,id);

    }

    @Override
    public AccountResponse remove(long id) {
        AccountResponse willRemove = findById(id);
        accountRepository.deleteById(id);
        return willRemove;
    }

    @Override
    public Account findByIdAccount(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        return null;
    }
}
