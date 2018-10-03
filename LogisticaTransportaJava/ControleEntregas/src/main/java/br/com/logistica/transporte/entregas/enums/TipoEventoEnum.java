package br.com.logistica.transporte.entregas.enums;

public enum TipoEventoEnum {
	
	INICIAR_COLETA( "O pedido será coletado." ),
	ENTREGUE_NO_ARMAZEM( "O pedido foi coletado para o armazém." ),
	COLETADO_PARA_ENTREGA( "O pedido foi coletado para ser entregue no destinatário." ),
	ENTREGUE_NO_DESTINATARIO( "O pedido foi entregue no destinatário." );
	
	private String mensagem;

	private TipoEventoEnum( String mensagem ) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public static TipoEventoEnum obterTipoEvento( int tipo )  {

		for ( TipoEventoEnum tipoEvento : TipoEventoEnum.values() ) {
			if ( tipoEvento.ordinal() == tipo ) {
				return tipoEvento;
			}
		}
		return null;
	}
}
