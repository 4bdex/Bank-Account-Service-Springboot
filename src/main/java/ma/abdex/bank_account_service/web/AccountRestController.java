package ma.abdex.bank_account_service.web;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.abdex.bank_account_service.entities.BankAccount;
import ma.abdex.bank_account_service.repositories.BankAccountRepository;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;


    public AccountRestController(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
      
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = accountRepository.findAll();
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= accountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        return bankAccount;
    }
    @PostMapping("/accounts")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        if(bankAccount.getAccountId() == null ) bankAccount.setAccountId(java.util.UUID.randomUUID().toString());
        return accountRepository.save(bankAccount);
    }
    @PutMapping("/accounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = accountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if(bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType() != null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        bankAccount= accountRepository.save(account);
        return bankAccount;
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        accountRepository.deleteById(id);
    }

    
}