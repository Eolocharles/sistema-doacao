package br.com.lp2.controller.response;

import br.com.lp2.core.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private String id;
    private String name;
    private String email;

    public UserResponse fromUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

        return this;
    }

}
