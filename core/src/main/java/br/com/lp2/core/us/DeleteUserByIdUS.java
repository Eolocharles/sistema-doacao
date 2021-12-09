package br.com.lp2.core.us;

import br.com.lp2.core.ports.driven.repository.UserRepositoryPort;
import br.com.lp2.core.ports.driver.DeleteItemByIdPort;
import br.com.lp2.core.ports.driver.DeleteUserByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteUserByIdUS(UserRepositoryPort repository)implements DeleteUserByIdPort {

    @Override
    public void apply(String id){
        repository.deleteById(id);
    }
}
