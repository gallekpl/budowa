package pl.transmar.budowa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BudowaApplication {

	private static final Logger log = LoggerFactory.getLogger(BudowaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BudowaApplication.class, args);
		log.info("Program started.");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
