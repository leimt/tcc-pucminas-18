package br.com.logistica.transporte.entregas.seguranca;

import org.springframework.stereotype.Component;

import br.com.logistica.transporte.entregas.seguranca.model.JwtUsuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidador {

    private String secret = "pucminas";	// // chave de assinatura

    /**
     * Converte o token recebido para um JwtUser.
     * @param token
     * @return
     */
    public JwtUsuario validate( String token ) {
        JwtUsuario jwtUsuario = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey( secret )	// chave de assinatura
                    .parseClaimsJws( token )
                    .getBody();

            jwtUsuario = new JwtUsuario();

            jwtUsuario.setLogin( body.getSubject() );
            //jwtUser.setId( Long.parseLong( ( String ) body.get( "userId" ) ) );
            jwtUsuario.setSenhaHash( (String) body.get( "senhaHash" ) );
            jwtUsuario.setRole( ( String ) body.get( "role" ) );
        } catch ( Exception e ) {
            System.out.println( e );
        }
        return jwtUsuario;
    }
}
