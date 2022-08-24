package com.example.yourself.Service;

import com.example.yourself.Enity.Account;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
        List<Account> getAll();

        Optional<Account> getOne(Integer id);

        Account create(Account account);

        Account update(Integer id, Account account) throws ChangeSetPersister.NotFoundException;

        Optional<Account> delete(Integer id) throws ChangeSetPersister.NotFoundException;
    }
