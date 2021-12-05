package br.com.lp2.repository.mongodb.adapters;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.repository.SaveUserRepositoryPort;

import java.util.UUID;

public class SavaUserRepository implements SaveUserRepositoryPort {

    @Override
    public String apply(User user) {
        System.out.println("user salvo com sucesso");
        return UUID.randomUUID().toString();
    }

    @Override
    public String apply(String id, User user) {
        return null;
    }
}
