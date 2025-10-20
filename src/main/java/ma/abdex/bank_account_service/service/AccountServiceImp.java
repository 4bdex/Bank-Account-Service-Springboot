package ma.abdex.bank_account_service.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ma.abdex.bank_account_service.dto.BankAccountRequestDTO;
import ma.abdex.bank_account_service.dto.BankAccountResponseDTO;
import ma.abdex.bank_account_service.entities.BankAccount;
import ma.abdex.bank_account_service.mappers.AccountMapper;
import ma.abdex.bank_account_service.repositories.BankAccountRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {
    
    private final BankAccountRepository bankAccountRepository;
    private final AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDTO);
        bankAccount.setAccountId(UUID.randomUUID().toString());
        bankAccount.setCreateAt(System.currentTimeMillis());
    
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(savedAccount);
    }
    
    @Override
    @Transactional(readOnly = true)
    public BankAccountResponseDTO getAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        return accountMapper.fromBankAccount(bankAccount);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<BankAccountResponseDTO> getAllAccounts() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        return accountMapper.fromBankAccountList(accounts);
    }
    
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        
        accountMapper.updateBankAccountFromDTO(bankAccount, bankAccountRequestDTO);
        
        BankAccount updatedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(updatedAccount);
    }
    
    @Override
    public void deleteAccount(String id) {
        if (!bankAccountRepository.existsById(id)) {
            throw new RuntimeException(String.format("Account %s not found", id));
        }
        bankAccountRepository.deleteById(id);
    }
}
