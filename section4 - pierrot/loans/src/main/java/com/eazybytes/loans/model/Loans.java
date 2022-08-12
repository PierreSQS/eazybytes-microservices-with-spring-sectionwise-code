package com.eazybytes.loans.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Loans {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanNumber;
	
	private int customerId;
	
	private LocalDate startDt;
	
	private String loanType;
	
	private int totalLoan;
	
	private int amountPaid;
	
	private int outstandingAmount;
	
	private String createDt;
	
}
