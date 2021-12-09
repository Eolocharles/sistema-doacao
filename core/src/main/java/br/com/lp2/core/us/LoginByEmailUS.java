package br.com.lp2.core.us;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.repository.UserRepositoryPort;
import br.com.lp2.core.ports.driven.security.GenerateTokenPort;
import br.com.lp2.core.ports.driver.LoginByEmailPort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public record LoginByEmailUS(UserRepositoryPort repository,
                             GenerateTokenPort generateToken)implements LoginByEmailPort {
    @Override
    public String apply(String email, String password){
        var user = repository.findByEmail(email);

        if(isNotUserValid(password,user)){
            throw new RuntimeException("Invalid User");
        }
        return generateToken.apply(user);
    }

    private boolean isNotUserValid(String password, User user){
        return Objects.isNull(user) || !user.isEnabled() || !user.getPassword().equals(password);
    }
}
