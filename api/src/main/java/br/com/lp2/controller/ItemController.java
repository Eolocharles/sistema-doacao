package br.com.lp2.controller;

import br.com.lp2.controller.request.ItemRequest;
import br.com.lp2.controller.response.ItemResponse;
import br.com.lp2.controller.response.UserResponse;
import br.com.lp2.core.ports.driver.itemdriver.CreateItemPort;
import br.com.lp2.core.ports.driver.itemdriver.DeleteItemByIdPort;
import br.com.lp2.core.ports.driver.itemdriver.FindItemByIdPort;
import br.com.lp2.core.ports.driver.userdriver.FindUserByIdPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itens")
public record ItemController(
        CreateItemPort createItemPort,
        FindItemByIdPort findItemByIdPort,
        DeleteItemByIdPort deleteItemByIdPort,
        FindUserByIdPort findUserByIdPort

) {
    @PostMapping
    public ItemResponse post(@RequestBody ItemRequest request){
        var user = new UserResponse().fromUser( findUserByIdPort().apply(request.getUserId().toString()));
        var item = request.toItem();
        item = createItemPort.apply(item);
        return  new ItemResponse().fromItem(item,user);
    }
    @GetMapping("{id}")
    public ItemResponse findById(@PathVariable String id) {
        var item = findItemByIdPort.apply(id);
        var user = findUserByIdPort.apply(item.getUserId().toString());
        return new ItemResponse().fromItem(item, new UserResponse().fromUser(user));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        deleteItemByIdPort.apply(id);
    }

}
