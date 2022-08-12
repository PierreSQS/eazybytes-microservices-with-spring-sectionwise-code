/**
 * 
 */
package com.eazybytes.cards.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.repository.CardsRepository;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class CardsController {

	private final CardsRepository cardsRepository;

	public CardsController(CardsRepository cardsRepository) {
		this.cardsRepository = cardsRepository;
	}

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		return cardsRepository.findByCustomerId(customer.getCustomerId());
	}

}
