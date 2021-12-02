package br.com.lp2.core.ports.driven;

public interface SendEmailTokenConfirmationPort {
    void apply(String email, String token);
}
