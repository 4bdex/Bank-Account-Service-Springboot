package ma.abdex.bank_account_service.repositories;

import ma.abdex.bank_account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}