package com.craftsman.funcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FuncServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(FuncServiceApp.class, args);
	}
	
	
    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
    	log.info("Initialize connectionFactory");
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }
}
	