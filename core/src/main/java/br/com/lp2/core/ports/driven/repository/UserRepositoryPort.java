package br.com.lp2.core.ports.driven.repository;

import br.com.lp2.core.domain.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(String id);

    boolean existsByEmail(String email);

    User findByTokenValue(String token);

    User findByEmail(String email);

    void deleteById(String id);
}
