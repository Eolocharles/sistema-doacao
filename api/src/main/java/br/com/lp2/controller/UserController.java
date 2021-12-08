package br.com.lp2.controller;

import br.com.lp2.controller.request.UserRequest;
import br.com.lp2.controller.response.UserResponse;
import br.com.lp2.core.ports.driver.CreateUserPort;
import br.com.lp2.core.ports.driver.DeleteUserByIdPort;
import br.com.lp2.core.ports.driver.EnableUserByTokenPort;
import br.com.lp2.core.ports.driver.FindUserByIdPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public record UserController (
    CreateUserPort createUserPort,
    FindUserByIdPort findUserByIdPort,
    EnableUserByTokenPort enableUserByTokenPort,
    DeleteUserByIdPort deleteUserByIdPort
){
    @PostMapping
    public UserResponse post(@RequestBody UserRequest request){
        var user = request.toUser();
        user = createUserPort.apply(user);
        return new UserResponse().fromUser(user);
    }

    @GetMapping("{id}")
    public UserResponse findById(@PathVariable String id) {
        var user = findUserByIdPort.apply(id);
        return new UserResponse().fromUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        deleteUserByIdPort.apply(id);
    }

    @PatchMapping("enable-by-token")
    public void enableByToken(@RequestParam String token) {
        enableUserByTokenPort.apply(token);
    }
}
