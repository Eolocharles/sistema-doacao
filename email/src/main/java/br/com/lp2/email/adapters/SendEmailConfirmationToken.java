package br.com.lp2.email.adapters;

import br.com.lp2.core.ports.driven.email.SendEmailTokenConfirmationPort;
import br.com.lp2.email.SmtpSendEmail;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public record SendEmailConfirmationToken(SmtpSendEmail sendEmail) implements SendEmailTokenConfirmationPort {

    @Async
    @Override
    public void  apply(String email, String token){
        sendEmail.apply(Set.of(email),"Confirmation Email!",token);
    }
}
