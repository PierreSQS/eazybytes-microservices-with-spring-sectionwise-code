/**
 * 
 */
package com.eazybytes.cards.controller;

import java.util.List;

import com.eazybytes.cards.config.CardsServiceConfig;
import com.eazybytes.cards.model.Properties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.repository.CardsRepository;

/**
 * Extended by Pierrot on 8/14/2022
 * @author Eazy Bytes
 *
 */

@RestController
public class CardsController {

	private final CardsRepository cardsRepository;
	private final CardsServiceConfig cardsServConfig;

	public CardsController(CardsRepository cardsRepository, CardsServiceConfig cardsServConfig) {
		this.cardsRepository = cardsRepository;
		this.cardsServConfig = cardsServConfig;
	}

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		return cardsRepository.findByCustomerId(customer.getCustomerId());
	}

	@GetMapping("/card/properties")
	public Properties getPropertiesDetails() {
		return new Properties(cardsServConfig.getMsg(), cardsServConfig.getBuildVersion(),
				cardsServConfig.getMailDetails(), cardsServConfig.getActiveBranches());
	}

}
