package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.accounts.model.Cards;
import com.eazybytes.accounts.model.Customer;

@FeignClient("cards")
public interface CardsFeignClient {

	@PostMapping("myCards")
	List<Cards> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationid,
							   @RequestBody Customer customer);
}
