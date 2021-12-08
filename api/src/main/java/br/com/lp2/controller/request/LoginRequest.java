package br.com.lp2.controller.request;

import br.com.lp2.core.domain.User;
import lombok.Setter;

@Setter
public class LoginRequest {
    private String password;
    private String email;

    public User toUser() {
        var user = new User();

        user.setPassword(password);
        user.setEmail(email);

        return user;
    }



}
