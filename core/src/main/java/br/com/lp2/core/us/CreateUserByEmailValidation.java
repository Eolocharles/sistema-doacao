package br.com.lp2.core.us;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.email.SendEmailTokenConfirmationPort;
import br.com.lp2.core.ports.driven.repository.SaveUserRepositoryPort;
import br.com.lp2.core.ports.driver.CreateUserPort;

import java.util.UUID;

public record CreateUserByEmailValidation(SendEmailTokenConfirmationPort sendEmailTokenConfirmationPort,
                                          SaveUserRepositoryPort saveUserRepositoryPort) implements CreateUserPort {

    @Override
    public String apply(User user){
        System.out.println("verificar");
        System.out.println("SalvarnoBD");
        System.out.println("enviaremail");
        var id = saveUserRepositoryPort.apply(user);
        sendEmailTokenConfirmationPort.apply(user.getEmail(),  "abcd309");

        return id;
    }

}
