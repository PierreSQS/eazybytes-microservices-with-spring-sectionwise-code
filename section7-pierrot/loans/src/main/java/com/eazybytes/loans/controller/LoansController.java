/**
 * 
 */
package com.eazybytes.loans.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.repository.LoansRepository;

/**
 * Optimized by Pierrot on 8/12/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class LoansController {

	private final LoansRepository loansRepository;

	public LoansController(LoansRepository loansRepository) {
		this.loansRepository = loansRepository;
	}

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer) {
		return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
	}

}
