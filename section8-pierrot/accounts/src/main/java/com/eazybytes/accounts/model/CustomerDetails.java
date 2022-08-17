/**
 * 
 */
package com.eazybytes.accounts.model;

import lombok.Data;

import java.util.List;

/**
 * Updated by Pierrot on 8/17/2022
 * @author EazyBytes
 *
 */
@Data
public class CustomerDetails {
	
	private Accounts accounts;
	private List<Loans> loans;
	private List<Cards> cards;
	
	

}
