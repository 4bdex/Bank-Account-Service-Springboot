package ma.abdex.bank_account_service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.abdex.bank_account_service.enums.AccountType;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String accountId;
    private Double balance;
    private String currency;
    private AccountType type;
    private Long createAt;
}