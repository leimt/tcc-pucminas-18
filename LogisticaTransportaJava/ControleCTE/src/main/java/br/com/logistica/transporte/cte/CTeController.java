package br.com.logistica.transporte.cte;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.transporte.cte.email.DisparadorEmailServico;
import br.com.logistica.transporte.cte.modelo.xml.CTEServico;

@RestController
@CrossOrigin( origins = "http://localhost:4200" )	// permite que o localhost:4200 faça requições de origem cruzada.
public class CTeController {

    private static Logger logger = LogManager.getLogger( CTeController.class );
    
    @Autowired
    private DisparadorEmailServico servico;
	
	@RequestMapping("/teste")
	public String testar() {
		//logger.info( getClass() + ": Log do CTE funciona!" );
		servico.enviar( "Teste!" );
		return "Serviço REST funciona!";
	}

	/**
	 * Método para enviar o CT-e.
	 * @return
	 */
	@RequestMapping("/rest/transmitir-cte")
	public String transmitirCte() {
		logger.info( "CT-e transmitido com sucesso!" );
		return "Transmitido";
	}
	
	/**
	 * Envia o e-mail de controle de CT-e.
	 * @return Sim - se o e-mail tiver sido enviado. Não - se o e-mail não foi enviado.
	 */
	@RequestMapping("/rest/enviar-email")
	public String enviarEmail() {
		Boolean enviado = servico.enviar( "Controle de CT-e!\nTeste de envio de e-mail!" );
		return ( enviado ) ? "Sim" : "Não";
	}
	
	@RequestMapping("/rest/obter-xml-emitente")
	public String obterXmlEmitente() {
		CTEServico servico = new CTEServico();
		String xml = servico.obterXmlEmitente();
		logger.info( "Retornando XML do emitente:\n" + xml );
		return xml;
	}
}
