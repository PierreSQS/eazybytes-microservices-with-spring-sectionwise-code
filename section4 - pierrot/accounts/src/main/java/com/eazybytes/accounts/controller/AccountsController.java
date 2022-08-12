/**
 * 
 */
package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.repository.AccountsRepository;

/**
 * Optimized by Pierrot on 8/12/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {
	
	private final AccountsRepository accountsRepository;

	public AccountsController(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		return accountsRepository.findByCustomerId(customer.getCustomerId());
	}

}
