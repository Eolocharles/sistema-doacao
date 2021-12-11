package br.com.lp2.controller;

import br.com.lp2.controller.request.LoginRequest;
import br.com.lp2.core.ports.driver.LoginByEmailPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public record LoginController(
        LoginByEmailPort loginByEmailPort
) {

    @PostMapping
    public String post(@RequestBody LoginRequest request) {
        var user = request.toUser();
        return loginByEmailPort.apply(user.getEmail(), user.getPassword());
    }

}
