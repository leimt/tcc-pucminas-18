package br.com.logistica.transporte.entregas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.transporte.entregas.enums.TipoEventoEnum;
import br.com.logistica.transporte.entregas.servico.email.DisparadorEmailServico;

@RestController
//@CrossOrigin( origins = "http://localhost:4200" )	// permite que o localhost:4200 faça requições de origem cruzada.
public class ProdutoController {
	
    private static Logger logger = LogManager.getLogger( ProdutoController.class );
    
    @Autowired
    DisparadorEmailServico servico;
    
    @RequestMapping("/rest/teste")
    public Produto produto( @RequestParam( value="name", defaultValue="World" ) String name ) {
    	logger.info( "Chamando método de controle de entregas!" );
//        return new Produto(counter.incrementAndGet(),
//                            String.format(template, name));
    	return new Produto( 1, "Produto de teste" );
    }
    
    @RequestMapping( path = "/produto/status", method = RequestMethod.GET )
    public void mudarStatusEntrega( @RequestParam( value="numEvento" ) Integer numEvento ) {
    	TipoEventoEnum tipoEventoEnum = TipoEventoEnum.obterTipoEvento( numEvento );
    	logger.info( tipoEventoEnum.getMensagem() );
    	servico.enviar( tipoEventoEnum.getMensagem() );
    }
}
