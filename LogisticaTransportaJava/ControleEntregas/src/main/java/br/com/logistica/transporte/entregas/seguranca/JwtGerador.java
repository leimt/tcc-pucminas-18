package br.com.logistica.transporte.entregas.seguranca;

import org.springframework.stereotype.Component;

import br.com.logistica.transporte.entregas.seguranca.model.JwtUsuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGerador {

	private static final String ASSINATURA = "pucminas";

    public String gerar( JwtUsuario jwtUsuario ) {
        Claims claims = Jwts.claims().setSubject( jwtUsuario.getLogin() );
        claims.put( "senhaHash", jwtUsuario.getSenhaHash() );
        claims.put( "role", jwtUsuario.getLogin() );
        
        System.out.println( getClass() + ": " + jwtUsuario.getLogin() + "\n"
        		+ jwtUsuario.getSenhaHash() );

        return Jwts.builder()
                .setClaims( claims )
                .signWith( SignatureAlgorithm.HS512, ASSINATURA )
                .compact();
    }
}
