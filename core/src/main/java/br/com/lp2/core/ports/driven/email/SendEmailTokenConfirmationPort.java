package br.com.lp2.core.ports.driven.email;

public interface SendEmailTokenConfirmationPort {
    void apply(String email, String token);
}
