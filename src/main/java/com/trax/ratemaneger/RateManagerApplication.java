package com.trax.ratemaneger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.trax.ratemanager.jpa.RateManagerJpaRepositoryImpl;

@SpringBootApplication
@ComponentScan(basePackages = { "com.trax.*" })
@EntityScan("com.trax.*")
@EnableJpaRepositories(repositoryBaseClass = RateManagerJpaRepositoryImpl.class, basePackages="com.trax")
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class RateManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateManagerApplication.class, args);
	}

}
		