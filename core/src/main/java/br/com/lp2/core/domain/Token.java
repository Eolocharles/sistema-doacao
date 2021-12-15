package br.com.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class Token {
    private String value;
    private LocalDateTime expireAt;

    public Token(int n){
        this.expireAt = LocalDateTime.now().plusMinutes(30);
        this.value = RandomStringUtils.randomAlphabetic(n);
    }
    public Token(){};

    public boolean hasExpired(){
        return this.expireAt.isBefore(LocalDateTime.now());
    }

    public boolean notHasExpired(){
        return !hasExpired();
    }
}
