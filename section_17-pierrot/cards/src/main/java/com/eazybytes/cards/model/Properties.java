package com.eazybytes.cards.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Properties {

	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
	private List<String> activeBranches;

	public Properties(String msg, String buildVersion, Map<String,
			String> mailDetails, List<String> activeBranches) {
		this.msg = msg;
		this.buildVersion = buildVersion;
		this.mailDetails = mailDetails;
		this.activeBranches = activeBranches;
	}

}
