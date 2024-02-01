package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.converter.DtoConverter;
import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;
import com.workintech.FSWEBS18D4JavaProjesi.repository.AccountRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponse> findAll() {
        return DtoConverter.convertToAccountResponseList(accountRepository.findAll());
    }

    @Override
    public AccountResponse findById(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()){
            return DtoConverter.convertToAccountResponse(accountOptional.get());
        }
        //TODO Exception handling must be done
        return null;
    }

    @Override
    public AccountResponse save(Account account) {
        return DtoConverter.convertToAccountResponse(accountRepository.save(account)) ;
    }

    @Override
    public AccountResponse remove(long id) {
        AccountResponse willRemove = findById(id);
        accountRepository.deleteById(id);
        return willRemove;
    }
}
