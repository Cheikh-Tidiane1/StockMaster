package com.tid.StockMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMasterApplication.class, args);
	}

}
