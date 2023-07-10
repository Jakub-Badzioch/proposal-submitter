package com.towerbuilder.proposalsubmitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProposalSubmitterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProposalSubmitterApplication.class, args);
	}
}
