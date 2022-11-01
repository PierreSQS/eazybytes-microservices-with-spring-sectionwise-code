/**
 * 
 */
package com.eazybytes.accounts.model;

import lombok.Data;

import java.util.List;

/**
 * Optimized by Pierrot 8/17/22
 * @author EazyBytes
 *
 */
@Data
public class CustomerDetails {
	
	private Accounts accounts;
	private List<Loans> loans;
	private List<Cards> cards;
	
	

}
