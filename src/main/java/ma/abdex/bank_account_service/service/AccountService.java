package ma.abdex.bank_account_service.service;

import java.util.List;

import ma.abdex.bank_account_service.dto.BankAccountRequestDTO;
import ma.abdex.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
   
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO getAccountById(String id);
    
    List<BankAccountResponseDTO> getAllAccounts();
    
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
    
    void deleteAccount(String id);
}
