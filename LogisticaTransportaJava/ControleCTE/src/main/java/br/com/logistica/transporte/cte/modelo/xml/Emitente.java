package br.com.logistica.transporte.cte.modelo.xml;

/**
 * Esta classe não uma entidade e também não segue convenções Java. Ela foi criada para facilitar a criação do arquivo
 * XML.
 * @author Elias Monteiro
 */
public class Emitente {
	private String CNPJ;
	private String IE;
	private String IEST;
	private String xNome;
	private String xFant;
	private EnderecoEmitente enderEmit;
	public Emitente(String cNPJ, String iE, String iEST, String xNome, String xFant, EnderecoEmitente enderEmit) {
		super();
		CNPJ = cNPJ;
		IE = iE;
		IEST = iEST;
		this.xNome = xNome;
		this.xFant = xFant;
		this.enderEmit = enderEmit;
	}
}
