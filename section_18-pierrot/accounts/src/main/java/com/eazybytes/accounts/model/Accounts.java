package com.eazybytes.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Accounts {
	@Id
	private long accountNumber;
	private int customerId;
	private String accountType;
	private String branchAddress;
	private LocalDate createDt;
	
}
