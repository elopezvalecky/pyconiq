package com.payconiq.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private StockRepository stockRepository;

	@Bean
	public CommandLineRunner setUp() {
		return (args) -> {
			stockRepository.save(new Stock("test", 0.5f));
		};
	}

}
