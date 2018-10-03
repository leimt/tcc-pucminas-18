package br.com.logistica.transporte.cte.modelo.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Serviço que simula a geração de um XML, parte do CT-e.
 * @author Elias Monteiro
 */
public class CTEServico {

	/**
	 * Obtém o XML do Emitente.
	 * @return Retornar um String com o XML.
	 */
	public String obterXmlEmitente() {
		EnderecoEmitente enderecoEmitente =
				new EnderecoEmitente( "Av. das Macieiras", "S/N", "2 andar", "Centro", "3559999", "Brasilia",
						"72800000", "DF", "6130251234" );
		Emitente emitente = new Emitente( "01227485000113", "123456789011", "1234567890", "Transportadora A Jato",
				"DDT", enderecoEmitente );
		
		XStream stream = new XStream( new DomDriver() );
		stream.alias( "emit", Emitente.class );
		return stream.toXML( emitente );
	}
}
