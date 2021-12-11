package br.com.lp2.core.ports.driver.userdriver;

public interface EnableUserByTokenPort {

    void apply(String token);
}
