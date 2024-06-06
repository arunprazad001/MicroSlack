package com.masai.MicroSlack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MicroSlackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroSlackApplication.class, args);
	}

}
