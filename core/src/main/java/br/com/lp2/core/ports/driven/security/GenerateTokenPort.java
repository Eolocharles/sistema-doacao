package br.com.lp2.core.ports.driven.security;

import br.com.lp2.core.domain.User;

public interface GenerateTokenPort {
    String apply(User user);
}
