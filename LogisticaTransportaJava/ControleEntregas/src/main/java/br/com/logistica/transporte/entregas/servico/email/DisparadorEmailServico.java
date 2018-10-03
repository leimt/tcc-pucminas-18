package br.com.logistica.transporte.entregas.servico.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class DisparadorEmailServico {
	
	// incluir email do destinatário aqui
    private static final String EMAIL_DESTINATARIO = "email-do-destinatario@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public String enviar( String conteudoEmail ) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo( EMAIL_DESTINATARIO );
        email.setSubject( "Acompanhe seu pedido!" );
        email.setText( conteudoEmail );

        try {
        	mailSender.send( email );
            return "Email enviado com sucesso!";
        } catch ( Exception e ) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}