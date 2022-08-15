/**
 * 
 */
package com.eazybytes.loans.controller;

import java.util.List;

import com.eazybytes.loans.config.LoansServiceConfig;
import com.eazybytes.loans.model.Properties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.repository.LoansRepository;

/**
 * Optimized by Pierrot on 8/14/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class LoansController {

	private final LoansRepository loansRepository;
	private final LoansServiceConfig loansServConfig;

	public LoansController(LoansRepository loansRepository, LoansServiceConfig loansServConfig) {
		this.loansRepository = loansRepository;
		this.loansServConfig = loansServConfig;
	}

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer) {
		return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
	}

	@GetMapping("/loan/properties")
	public Properties getPropertiesDetails() {
		return new Properties(loansServConfig.getMsg(), loansServConfig.getBuildVersion(),
				loansServConfig.getMailDetails(), loansServConfig.getActiveBranches());
	}


}
