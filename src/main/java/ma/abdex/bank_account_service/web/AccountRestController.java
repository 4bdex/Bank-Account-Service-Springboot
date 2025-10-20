package ma.abdex.bank_account_service.web;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ma.abdex.bank_account_service.dto.BankAccountRequestDTO;
import ma.abdex.bank_account_service.dto.BankAccountResponseDTO;
import ma.abdex.bank_account_service.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountRestController {
    
    private final AccountService accountService;

    @GetMapping
    public List<BankAccountResponseDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }
    
    @GetMapping("/{id}")
    public BankAccountResponseDTO getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }
    
    @PostMapping
    public BankAccountResponseDTO createAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return accountService.addAccount(bankAccountRequestDTO);
    }
    
    @PutMapping("/{id}")
    public BankAccountResponseDTO updateAccount(
            @PathVariable String id, 
            @RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return accountService.updateAccount(id, bankAccountRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}