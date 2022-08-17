package com.eazybytes.accounts.model;

import lombok.Data;

import java.sql.Date;

/**
 * Updated by Pierrot on 8/17/2022
 * @author EazyBytes
 *
 */
@Data
public class Loans {

	private int loanNumber;

	private int customerId;

	private Date startDt;

	private String loanType;

	private int totalLoan;

	private int amountPaid;

	private int outstandingAmount;

	private String createDt;

}
