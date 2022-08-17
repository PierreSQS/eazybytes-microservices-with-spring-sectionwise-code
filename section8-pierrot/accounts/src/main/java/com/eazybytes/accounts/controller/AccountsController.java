/**
 *
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.config.AccountServiceConfig;
import com.eazybytes.accounts.model.*;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.service.client.CardsFeignClient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Updated by Pierrot on 8/17/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {

    private final AccountsRepository accountsRepository;
    private final AccountServiceConfig accountServConfig;
    private final LoansFeignClient loansFeignClient;
    private final CardsFeignClient cardsFeignClient;

    public AccountsController(AccountsRepository accountsRepository, AccountServiceConfig accountServConfig,
                              LoansFeignClient loansFeignClient, CardsFeignClient cardsFeignClient) {
        this.accountsRepository = accountsRepository;
        this.accountServConfig = accountServConfig;
        this.loansFeignClient = loansFeignClient;
        this.cardsFeignClient = cardsFeignClient;
    }

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {

        return accountsRepository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/account/properties")
    public Properties getPropertiesDetails() {
        return new Properties(accountServConfig.getMsg(), accountServConfig.getBuildVersion(),
                accountServConfig.getMailDetails(), accountServConfig.getActiveBranches());
    }
	@PostMapping("/myCustomerDetails")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loansFeignClient.getLoansDetails(customer);
		List<Cards> cards = cardsFeignClient.getCardDetails(customer);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);
		
		return customerDetails;

	}

}
