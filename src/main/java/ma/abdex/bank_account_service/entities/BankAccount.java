package ma.abdex.bank_account_service.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.abdex.bank_account_service.enums.AccountType;

import java.time.LocalDate;
@Entity
@Data @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}