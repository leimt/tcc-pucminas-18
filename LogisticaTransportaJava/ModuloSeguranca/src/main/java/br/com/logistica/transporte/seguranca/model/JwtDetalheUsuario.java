package br.com.logistica.transporte.seguranca.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtDetalheUsuario implements UserDetails {

	private static final long serialVersionUID = -6841755995920129793L;
	private String login;
	private String senhaHash;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDetalheUsuario( String login, String senhaHash, String token,
    		List<GrantedAuthority> grantedAuthorities ) {
        this.login 	 	 = login;
        this.senhaHash 	 = senhaHash;
        this.token	  	 = token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return login;
    }

    public String getToken() {
        return token;
    }

    public String getSenhaHash() {
        return senhaHash;
    }
}
