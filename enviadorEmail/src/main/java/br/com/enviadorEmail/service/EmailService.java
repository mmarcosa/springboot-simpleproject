package br.com.enviadorEmail.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void enviarEmail(String nome, String emailConvidado) {
		try {
            Email email = new SimpleEmail();
            email.setHostName("smtp-mail.outlook.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("email", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("marcos.barbosa8@fatec.sp.gov.br");
            email.setSubject("Você foi convidado pelo teste de  ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
	}
}
