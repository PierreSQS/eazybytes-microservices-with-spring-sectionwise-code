package com.eazybytes.cards.controller;

import com.eazybytes.cards.config.CardsServiceConfig;
import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.repository.CardsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardsController.class)
class CardsControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CardsRepository cardsRepo;

    @MockBean
    CardsServiceConfig cardsServiceConfig;

    Cards card1, card2;

    @BeforeEach
    void setUp() {
        card1 = new Cards();
        card1.setCardId(1);
        card1.setCardType("Visa");
        card1.setCardNumber("1111111111");

        card2 = new Cards();
        card2.setCardId(2);
        card2.setCardType("Amex");
        card2.setCardNumber("2222222222");

    }

    @Test
    void getCardDetails() throws Exception {
        // Given
        Customer customerToFind = new Customer();
        customerToFind.setCustomerId(1);
        given(cardsRepo.findByCustomerId(anyInt())).willReturn(List.of(card1, card2));

        // When and Then
        mockMvc.perform(post("/myCards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerToFind)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andDo(print());

    }
}