package br.com.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Token {
    private String value;
    private LocalDateTime expireAt;

    public Token(){
        this.expireAt = LocalDateTime.now().plusMinutes(30);
    }

    public boolean hasExpired(){
        return this.expireAt.isBefore(LocalDateTime.now());
    }

    public boolean notHasExpired(){
        return !hasExpired();
    }
}
