package com.kanerika.product.ratemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kanerika.product.ratemanager.jpa.RateManagerJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = RateManagerJpaRepositoryImpl.class)
public class RateManagerMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateManagerMainApplication.class, args);
	}

}
		