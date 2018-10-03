package br.com.logistica.transporte.cte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	/**
	 * Inicia a aplicação Spring-boot.
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
    
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
    	return super.configure(builder);
    }
}