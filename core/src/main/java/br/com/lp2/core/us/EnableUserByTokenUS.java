package br.com.lp2.core.us;

import br.com.lp2.core.ports.driven.repository.UserRepositoryPort;
import br.com.lp2.core.ports.driver.EnableUserByTokenPort;
import org.springframework.stereotype.Service;

@Service
public record EnableUserByTokenUS(UserRepositoryPort repository)implements EnableUserByTokenPort {

    @Override
    public void apply(String token){

        var user = repository.findByTokenValue(token);

        if (user != null && user.getToken().notHasExpired()){
            user.setEnabled(true);
            user.setToken(null);
        }
        repository.save(user);
    }
}
