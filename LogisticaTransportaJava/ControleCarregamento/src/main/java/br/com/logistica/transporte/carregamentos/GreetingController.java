package br.com.logistica.transporte.carregamentos;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    private static Logger logger = LogManager.getLogger(GreetingController.class);

    @CrossOrigin(origins = "http://localhost:4200")	// permite que o localhost:4200 fa�a requi��es de origem cruzada.
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	logger.info( "Chamando servico REST!" );
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
