package br.com.lp2.core.us;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.repository.UserRepositoryPort;
import br.com.lp2.core.ports.driver.FindUserByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindUserByIdUS(UserRepositoryPort repository) implements FindUserByIdPort {
    @Override
    public User apply(String id) {
        return repository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));
    }
}
