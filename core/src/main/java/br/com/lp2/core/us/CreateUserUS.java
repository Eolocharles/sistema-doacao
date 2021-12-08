package br.com.lp2.core.us;

import br.com.lp2.core.domain.Token;
import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.email.SendEmailTokenConfirmationPort;
import br.com.lp2.core.ports.driven.repository.UserRepositoryPort;
import br.com.lp2.core.ports.driver.CreateUserPort;
import org.springframework.stereotype.Service;

@Service
public record CreateUserUS(SendEmailTokenConfirmationPort sendEmailTokenConfirmationPort,
                           UserRepositoryPort repository) implements CreateUserPort {

    @Override
    public User apply(User user) {

        if (repository.existsByEmail(user.getEmail()))
            throw new IllegalStateException("Email já cadastrado!");

        user.setToken(new Token(4));

        user = repository.save(user);

        sendEmailTokenConfirmationPort.apply(user.getEmail(), user.getToken().getValue());

        return user;
    }

}
