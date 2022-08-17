/**
 * 
 */
package com.eazybytes.cards.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Optimized by Pierrot 8/18/22
 * @author Eazy Bytes
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cards")
public class CardsServiceConfig {

	 private String msg;
	 private String buildVersion;
	 private Map<String, String> mailDetails;
	 private List<String> activeBranches;

}
