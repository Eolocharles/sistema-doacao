package br.com.lp2.core.ports.driven.repository;

import br.com.lp2.core.domain.User;

public interface SaveUserRepositoryPort {
    String apply(User user);
    String apply(String id, User user);
}
