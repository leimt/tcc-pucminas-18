package br.com.logistica.transporte.cte.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    
    private static Logger logger = LogManager.getLogger( DisparadorEmailServico.class );

    public boolean enviar( String conteudoEmail ) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo( EMAIL_DESTINATARIO );
        email.setSubject( "Acompanhe seu pedido!" );
        email.setText( conteudoEmail );

        try {
        	mailSender.send( email );
        	logger.info( getClass() + ": Email enviado para " + EMAIL_DESTINATARIO  );
            return true;
        } catch ( Exception e ) {
            e.printStackTrace();
            logger.error( getClass() + ": Erro ao enviar email para " + EMAIL_DESTINATARIO );
            return false;
        }
    }
}