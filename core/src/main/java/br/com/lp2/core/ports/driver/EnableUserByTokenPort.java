package br.com.lp2.core.ports.driver;

public interface EnableUserByTokenPort {

    void apply(String token);
}
