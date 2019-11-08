package com.rcm.app.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.rcm.app.rps")
public class RockPaperScissorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorApplication.class, args);
	}

}
