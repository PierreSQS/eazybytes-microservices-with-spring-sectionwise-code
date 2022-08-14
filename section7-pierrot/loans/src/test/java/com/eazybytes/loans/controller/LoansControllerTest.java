package com.eazybytes.loans.controller;

import com.eazybytes.loans.config.LoansServiceConfig;
import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.repository.LoansRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoansController.class)
class LoansControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LoansRepository loansRepo;

    @MockBean
    LoansServiceConfig loansServConfig;

    Loans loan1, loan2;

    @BeforeEach
    void setUp() {
        loan1 = new Loans();
        loan1.setCustomerId(1);
        loan1.setLoanNumber(1111111);
        loan1.setAmountPaid(11000);
        loan1.setCreateDt(LocalDate.now().toString());

        loan2 = new Loans();
        loan2.setCustomerId(1);
        loan2.setLoanNumber(2222222);
        loan2.setAmountPaid(22000);
        loan2.setCreateDt(LocalDate.now().toString());

    }

    @Test
    void getLoansDetails() throws Exception{
        // Given
        Customer customerToFind = new Customer();
        customerToFind.setCustomerId(1);
        given(loansRepo.findByCustomerIdOrderByStartDtDesc(anyInt())).willReturn(List.of(loan1, loan2));

        // When and Then
        mockMvc.perform(post("/myLoans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerToFind)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andDo(print());
    }

}
