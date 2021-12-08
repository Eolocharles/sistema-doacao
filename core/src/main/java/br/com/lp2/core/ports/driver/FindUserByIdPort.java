package br.com.lp2.core.ports.driver;

import br.com.lp2.core.domain.User;

public interface FindUserByIdPort {

    User apply(String id);
}
