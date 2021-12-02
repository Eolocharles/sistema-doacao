package br.com.lp2.core.us;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.SendEmailTokenConfirmationPort;
import br.com.lp2.core.ports.driver.CreateUserPort;

import java.util.UUID;

public record CreateUserByEmailValidation(SendEmailTokenConfirmationPort sendEmailTokenConfirmationPort

) implements CreateUserPort {

    @Override
    public String apply(User user){
        System.out.println("verificar");
        System.out.println("SalvarnoBD");
        System.out.println("enviaremail");

        sendEmailTokenConfirmationPort.apply(user.getEmail(), token, "abcd309");
        return UUID.randomUUID().toString();
    }

}
