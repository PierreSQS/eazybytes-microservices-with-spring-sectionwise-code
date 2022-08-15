/**
 *
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.config.AccountServiceConfig;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Properties;
import com.eazybytes.accounts.repository.AccountsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Optimized by Pierrot on 8/14/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {

    private final AccountsRepository accountsRepository;
    private final AccountServiceConfig accountServConfig;

    public AccountsController(AccountsRepository accountsRepository, AccountServiceConfig accountServConfig) {
        this.accountsRepository = accountsRepository;
        this.accountServConfig = accountServConfig;
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

}
