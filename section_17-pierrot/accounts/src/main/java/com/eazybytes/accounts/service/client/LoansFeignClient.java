package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Loans;

@FeignClient("loans")
public interface LoansFeignClient {

	@PostMapping("myLoans")
	List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationid,
								@RequestBody Customer customer);
}
