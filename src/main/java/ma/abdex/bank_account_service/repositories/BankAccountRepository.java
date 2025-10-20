package ma.abdex.bank_account_service.repositories;

import ma.abdex.bank_account_service.entities.BankAccount;
import ma.abdex.bank_account_service.enums.AccountType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "byType")
    List<BankAccount> findByType(@Param("type") AccountType type);
}