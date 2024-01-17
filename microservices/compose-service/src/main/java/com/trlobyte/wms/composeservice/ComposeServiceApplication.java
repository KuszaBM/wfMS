package com.trlobyte.wms.composeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.kusza")
@ComponentScan("com.trlobyte")
public class ComposeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComposeServiceApplication.class, args);
	}

}
