package br.com.logistica.transporte.seguranca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.logistica.transporte.seguranca.model.JwtTokenAutenticacao;
import br.com.logistica.transporte.seguranca.model.JwtUsuario;
import br.com.logistica.transporte.seguranca.model.JwtDetalheUsuario;

@Component
public class JwtProvedorAutenticacao extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidador validador;

    @Override
    protected void additionalAuthenticationChecks( UserDetails userDetails,
    		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken ) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser( String username,
    		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtTokenAutenticacao jwtAuthenticationToken = ( JwtTokenAutenticacao ) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        JwtUsuario jwtUser = validador.validate( token );	// converte o token recebido para um JwtUser

        if ( jwtUser == null ) {	// lança exeção se não obtiver o jwtUser
            throw new RuntimeException( "JWT Token is incorrect" );
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList( jwtUser.getRole() );
        return new JwtDetalheUsuario( jwtUser.getLogin(), jwtUser.getSenhaHash(), token, grantedAuthorities );
    }

    @Override
    public boolean supports( Class<?> aClass ) {
        return ( JwtTokenAutenticacao.class.isAssignableFrom( aClass ) );
    }
}
