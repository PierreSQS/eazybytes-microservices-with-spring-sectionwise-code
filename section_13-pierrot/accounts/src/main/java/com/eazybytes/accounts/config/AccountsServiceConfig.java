/**
 * 
 */
package com.eazybytes.accounts.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Optimized by Pierrot 8/17/22
 * @author Eazy Bytes
 *
 */
@Configuration
@ConfigurationProperties(prefix = "accounts")
@Data
public class AccountsServiceConfig {

	 private String msg;
	 private String buildVersion;
	 private Map<String, String> mailDetails;
	 private List<String> activeBranches;

}
