package com.example.SpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * Utiliza la anotación @SpringBootApplication para indicar que es una aplicación Spring Boot.
 */
@SpringBootApplication
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 * Método principal de la aplicación.
	 *
	 * @param args Argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		logger.debug("Mi mensaje debug");
	}
}