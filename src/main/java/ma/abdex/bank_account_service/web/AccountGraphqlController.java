package ma.abdex.bank_account_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import ma.abdex.bank_account_service.dto.BankAccountRequestDTO;
import ma.abdex.bank_account_service.dto.BankAccountResponseDTO;
import ma.abdex.bank_account_service.service.AccountService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountGraphqlController {
    private final AccountService accountService;


    @QueryMapping
    public List<BankAccountResponseDTO> accounts() {
        return accountService.getAllAccounts();
    }


    @QueryMapping
    public BankAccountResponseDTO accountById(@Argument String id) {
        return accountService.getAccountById(id);
    }


    @MutationMapping
    public BankAccountResponseDTO createAccount(@Argument BankAccountRequestDTO request) {
        return accountService.addAccount(request);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO request) {
        return accountService.updateAccount(id, request);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
        return true;
    }
}
