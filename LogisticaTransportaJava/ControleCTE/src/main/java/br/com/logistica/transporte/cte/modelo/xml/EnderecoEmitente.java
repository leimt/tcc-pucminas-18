package br.com.logistica.transporte.cte.modelo.xml;

/**
 * Esta classe não uma entidade e também não segue convenções Java. Ela foi criada para facilitar a criação do arquivo
 * XML.
 * @author Elias Monteiro
 */
public class EnderecoEmitente {
	private String xLgr;
	private String nro;
	private String xCpl;
	private String xBairro;
	private String cMun;
	private String xMun;
	private String CEP;
	private String UF;
	private String fone;
	
	public EnderecoEmitente(String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String CEP,
			String UF, String fone) {
		super();
		this.xLgr = xLgr;
		this.nro = nro;
		this.xCpl = xCpl;
		this.xBairro = xBairro;
		this.cMun = cMun;
		this.xMun = xMun;
		this.CEP = CEP;
		this.UF = UF;
		this.fone = fone;
	}
}
