package com.quotes.premium;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotes.premium.dto.PremiumResponse;
import com.quotes.premium.dto.ApiResponse;
import com.quotes.premium.dto.PremiumRequest;
import com.quotes.premium.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PremiumApplication {

	@Autowired
	private PremiumService premiumService;

	public static void main(String[] args) {
		SpringApplication.run(PremiumApplication.class, args);
	}

	@Bean
	public CommandLineRunner runCommandLineRunner() {
		final ObjectMapper objectMapper = new ObjectMapper();
		return (final String... commandLineArgs) -> {
			if (0 < commandLineArgs.length) {
				final String input = commandLineArgs[0];
				final ApiResponse<PremiumResponse> result = (this.premiumService.calculatePremium(objectMapper.readValue(input, PremiumRequest.class)));
				System.out.println("Premium: " + result);
			}
		};
	}

}
