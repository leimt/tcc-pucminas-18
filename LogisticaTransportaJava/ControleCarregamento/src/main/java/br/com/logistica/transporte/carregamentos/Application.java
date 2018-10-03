package br.com.logistica.transporte.carregamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        SpringApplication.run( applicationClass, args );
    }
    
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
    	return super.configure(builder);
    }
    
    private static Class<App> applicationClass = App.class;
}