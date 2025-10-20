package ma.abdex.bank_account_service.entities;

import ma.abdex.bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

// spring data graphQL version
@Projection(name = "P1", types = BankAccount.class)
public interface AccountProjection {
	public String getAccountId();
    public AccountType getType();
    public Double getBalance();
}
