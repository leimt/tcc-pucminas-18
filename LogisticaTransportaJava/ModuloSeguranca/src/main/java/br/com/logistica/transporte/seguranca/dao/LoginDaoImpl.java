package br.com.logistica.transporte.seguranca.dao;

import java.util.Arrays;
import java.util.List;

import br.com.logistica.transporte.seguranca.model.JwtUsuario;

public class LoginDaoImpl {

	private List<JwtUsuario> usuarios = null;
	
	public LoginDaoImpl() {
		JwtUsuario admin = new JwtUsuario( "admin",
				"c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec",
				"admin" );
		JwtUsuario funcionario = new JwtUsuario( "func123",
				"b0dd090a68f8cbdbd4234d991460d8c6f46ccafd3a6dcb8b9fc0dc8f7f7d11e458d8c2ef3d7749c56eb3872c0274e9b7ac23f6136488d2e8d8f990585d4c4ba2",
				"func" );
		JwtUsuario motorista = new JwtUsuario( "motorista123",
				"ba6903076238b0bd0f1b459078c326321a0c7364e167c0dc8ad2e0810574a5d6800411d754ecb08f5cdcef41389239b4dd28d43743a6b25a69a4341582003704",
				"motorista" );
		
		this.usuarios = Arrays.asList( admin, funcionario, motorista );
	}
	
	/**
	 * Busca a senha do usuário no BD.
	 * @param login
	 * @return
	 */
	public String obter( String login ) {
		
		for ( JwtUsuario jwtUsuario : this.usuarios ) {
			if ( jwtUsuario.getLogin().equals( login ) ) {
				return jwtUsuario.getSenhaHash();
			}
		}
		return null;
	}

	/**
	 * Obtém um objeto JwtUsuario.
	 * @param login
	 * @return
	 */
	public JwtUsuario obterUsuario( String login ) {
		
		for ( JwtUsuario jwtUsuario : this.usuarios ) {
			if ( jwtUsuario.getLogin().equals( login ) ) {
				return jwtUsuario;
			}
		}
		return null;
	}
}
