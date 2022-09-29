package com.eazybytes.loans.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
public class Loans {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanNumber;
	
	private int customerId;
	
	private Date startDt;
	
	private String loanType;
	
	private int totalLoan;
	
	private int amountPaid;
	
	private int outstandingAmount;
	
	private String createDt;

}
