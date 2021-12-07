package br.com.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    private Token token;
}
