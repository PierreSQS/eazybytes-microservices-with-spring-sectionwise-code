package com.eazybytes.accounts.model;

import lombok.Data;

import java.sql.Date;

/**
 * Updated by Pierrot on 8/17/2022
 * @author EazyBytes
 *
 */
@Data
public class Cards {

	private int cardId;

	private int customerId;

	private String cardNumber;

	private String cardType;

	private int totalLimit;

	private int amountUsed;

	private int availableAmount;

	private Date createDt;

}
