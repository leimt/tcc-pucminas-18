package br.com.logistica.transporte.entregas.seguranca;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import br.com.logistica.transporte.entregas.seguranca.model.JwtTokenAutenticacao;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/rest/**");	// o filtro irá escutar este caminho relativo
    }

    @Override
    public Authentication attemptAuthentication( HttpServletRequest httpServletRequest,
    		HttpServletResponse httpServletResponse ) throws AuthenticationException, IOException, ServletException {
    	System.out.println( getClass() + ".attemptAuthentication()" );
        String header = httpServletRequest.getHeader( "Authorization" );	// valor a ser enviado no cabeçalho

        System.out.println( httpServletRequest.getRequestURL() );
        
        if ( header == null || !header.startsWith( "Token " ) ) {
            throw new RuntimeException( "JWT Token is missing" );
        }

        String authenticationToken = header.substring( 6 );	// pega o valor a partir da posição 6

        JwtTokenAutenticacao token = new JwtTokenAutenticacao( authenticationToken );
        return getAuthenticationManager().authenticate( token );
    }

    @Override
    protected void successfulAuthentication( HttpServletRequest request, HttpServletResponse response,
    		FilterChain chain, Authentication authResult ) throws IOException, ServletException {
    	System.out.println( getClass() + ".successfulAuthentication()" );
    	super.successfulAuthentication( request, response, chain, authResult );
        chain.doFilter( request, response );
    }
}
