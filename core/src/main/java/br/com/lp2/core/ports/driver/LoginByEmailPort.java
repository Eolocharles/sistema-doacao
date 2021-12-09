package br.com.lp2.core.ports.driver;

public interface LoginByEmailPort {

    String apply(String email, String password);
}
