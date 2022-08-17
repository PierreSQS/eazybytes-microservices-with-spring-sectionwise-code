package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.config.AccountServiceConfig;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.service.client.CardsFeignClient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountsController.class)
class AccountsControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountsRepository accountsRepo;

    @MockBean
    AccountServiceConfig accountServConfig;

    @MockBean
    CardsFeignClient cardsFeignClient;

    @MockBean
    LoansFeignClient loansFeignClient;

    Accounts savedAccount;

    @BeforeEach
    void setUp() {
       savedAccount = new Accounts();
       savedAccount.setAccountType("private");
       savedAccount.setAccountNumber(1111111111L);
       savedAccount.setCreateDt(LocalDate.now());
    }

    @Test
    void getAccountDetails() throws Exception {
        // Given
        Customer customerToFind = new Customer();
        customerToFind.setCustomerId(1);
        given(accountsRepo.findByCustomerId(anyInt())).willReturn(savedAccount);

        // When and Then
        mockMvc.perform(post("/myAccount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerToFind)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1111111111"))
                .andDo(print());
    }
}