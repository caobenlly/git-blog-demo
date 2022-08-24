package com.example.yourself.Controller;


import com.example.yourself.DTO.AccountDTO;
import com.example.yourself.Enity.Account;
import com.example.yourself.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping()
    public List<AccountDTO> getAllAccount(){
        List<Account> accounts =  accountService.getAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (Account account:
             accounts) {
            AccountDTO accountDTO = new AccountDTO(account.getId(),account.getUsername(),account.getDepartment().getName());
            accountDTOS.add(accountDTO);
        }
        return accountDTOS;
    }

    @GetMapping  (value = "/{id}")
    public Optional<Account> getAccountById(@PathVariable(name = "id") Integer id){
        return  accountService.getOne(id);
    }

    @PutMapping(value = "/{id}")
    public Account update(@PathVariable(name = "id") Integer id,@RequestBody Account account)
            throws ChangeSetPersister.NotFoundException {
        return accountService.update(id, account);
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.create(account);
    }


    @DeleteMapping(value = "/{id}")
    public Optional<Account> create(@PathVariable(name = "id") Integer id) throws ChangeSetPersister.NotFoundException {
        return accountService.delete(id);
    }

}
