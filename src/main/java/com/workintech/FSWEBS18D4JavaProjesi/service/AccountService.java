package com.workintech.FSWEBS18D4JavaProjesi.service;

import com.workintech.FSWEBS18D4JavaProjesi.dto.AccountResponse;
import com.workintech.FSWEBS18D4JavaProjesi.entity.Account;

import java.util.List;

public interface AccountService {

    List<AccountResponse> findAll();

    AccountResponse findById(long id);

    AccountResponse save(Account account);

    AccountResponse remove(long id);

}
