/**
 * 
 */
package com.eazybytes.cards.controller;

import com.eazybytes.cards.config.CardsServiceConfig;
import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.model.Properties;
import com.eazybytes.cards.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Optimized by Pierrot 8/18/22
 * @author Eazy Bytes
 *
 */

@RestController
public class CardsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CardsController.class);

	@Autowired
	private CardsRepository cardsRepository;
	
	@Autowired
	CardsServiceConfig cardsConfig;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationid,
									  @RequestBody Customer customer) {
		logger.info("getCardDetails() method started");
		logger.info("getCardDetails() method ended");
		return 	cardsRepository.findByCustomerId(customer.getCustomerId());
	}
	
	@GetMapping("/cards/properties")
	public Properties getPropertyDetails() {
		return new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
				cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());

	}

}
