package com.example.yourself.Service;

import com.example.yourself.Enity.Account;
import com.example.yourself.Reponsitory.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService implements IAccountService{
    @Autowired
    private  AccountRepo accountRepo;


    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Optional<Account> getOne(Integer id) {
        return accountRepo.findById(id);
    }

    @Override
    public Account create(Account account) {

        return accountRepo.save(account);
    }

    @Override
    public Account update(Integer id, Account account) throws ChangeSetPersister.NotFoundException {
        getOne(id)
                .map(acc ->{
                    account.setId(id);
                    accountRepo.save(account);
                    return acc;
                });
        return  account;
    }

    @Override
    public Optional<Account> delete(Integer id) throws ChangeSetPersister.NotFoundException {
        return getOne(id)
                .map(acc -> {
                    acc.setId(id);
                    accountRepo.delete(acc);
                    return acc;
                });
    }
}
