package br.com.logistica.transporte.seguranca.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.transporte.seguranca.JwtGerador;
import br.com.logistica.transporte.seguranca.dao.LoginDaoImpl;
import br.com.logistica.transporte.seguranca.model.JwtUsuario;
import br.com.logistica.transporte.seguranca.model.Permissao;

@CrossOrigin	// permite a origem cruzada para todos os clientes (configuração apenas para teste)
@RestController
public class TokenController {

    private JwtGerador jwtGenerator;

    public TokenController( JwtGerador jwtGerador ) {
        this.jwtGenerator = jwtGerador;
    }

    @PostMapping
    @RequestMapping("/token")
    public Permissao gerar( @RequestBody final JwtUsuario jwtUsuario ) {
    	LoginDaoImpl daoImpl = new LoginDaoImpl();
        Permissao permissao  = new Permissao();
        
    	JwtUsuario usuario = daoImpl.obterUsuario( jwtUsuario.getLogin() );
    	permissao.setToken( jwtGenerator.gerar( jwtUsuario ) );
    	permissao.setPerfil( usuario.getRole() );
    	return permissao;
    }
}
