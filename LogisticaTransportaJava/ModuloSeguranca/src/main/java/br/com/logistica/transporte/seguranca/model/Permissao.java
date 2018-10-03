package br.com.logistica.transporte.seguranca.model;

/**
 * Esta classe retorna o token de acesso e perfil do usuário.
 * 
 * @author Elias Monteiro
 */
public class Permissao {
	private String perfil;
	private String token;

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
