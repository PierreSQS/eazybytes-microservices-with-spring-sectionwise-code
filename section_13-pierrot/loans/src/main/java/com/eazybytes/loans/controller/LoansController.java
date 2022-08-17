/**
 * 
 */
package com.eazybytes.loans.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.loans.config.LoansServiceConfig;
import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.model.Properties;
import com.eazybytes.loans.repository.LoansRepository;

/**
 * Optimized by Pierrot 8/17/22
 * @author Eazy Bytes
 *
 */

@RestController
public class LoansController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoansController.class);

	private final LoansRepository loansRepository;
	private final LoansServiceConfig loansConfig;

	public LoansController(LoansRepository loansRepository, LoansServiceConfig loansConfig) {
		this.loansRepository = loansRepository;
		this.loansConfig = loansConfig;
	}

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationid,@RequestBody Customer customer) {
		logger.info("getLoansDetails() method started");
		logger.info("getLoansDetails() method ended");
		return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
	}
	
	@GetMapping("/loans/properties")
	public Properties getPropertyDetails() {
		return new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
				loansConfig.getMailDetails(), loansConfig.getActiveBranches());

	}

}
