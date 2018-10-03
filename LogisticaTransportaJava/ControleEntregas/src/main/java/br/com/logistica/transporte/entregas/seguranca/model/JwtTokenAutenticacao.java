package br.com.logistica.transporte.entregas.seguranca.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtTokenAutenticacao extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 7294380408522591765L;
	private String token;

    public JwtTokenAutenticacao( String token ) {
        super( null, null );
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
