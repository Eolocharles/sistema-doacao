package br.com.lp2.email.adapters;

import br.com.lp2.core.ports.driven.SendEmailTokenConfirmationPort;

import javax.xml.transform.stream.StreamSource;

public class SendEmailConfirmationToken implements SendEmailTokenConfirmationPort {

    @Override
    public void  apply(String email, String token){
        System.out.println("send email..."+ email);
        System.out.println("token..."+ token);
    }
}
