package com.example.projetobserverdesignpattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class ProjetObserverDesignPatternApplicationTests {

	@Configuration
	public static class PODPConfig {
		@Bean
		public void compte() {
			return;
		}
	}

	@Test
	void contextLoads() {
	}

}
