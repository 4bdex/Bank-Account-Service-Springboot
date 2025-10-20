package ma.abdex.bank_account_service.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import ma.abdex.bank_account_service.enums.AccountType;

// import java.util.Date;
@Entity
@Data @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private Long createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}