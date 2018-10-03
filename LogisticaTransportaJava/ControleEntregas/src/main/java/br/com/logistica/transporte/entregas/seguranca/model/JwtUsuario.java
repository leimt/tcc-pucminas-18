package br.com.logistica.transporte.entregas.seguranca.model;

/**
 * JavaBeans que contém/recebe as informações de userName, id e role.
 * 
 * @author Elias.Monteiro
 */
public class JwtUsuario {
	private String login;
	private String senhaHash;
	private String role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
