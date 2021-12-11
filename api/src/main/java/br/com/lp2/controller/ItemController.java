package br.com.lp2.controller;

import br.com.lp2.controller.request.ItemRequest;
import br.com.lp2.controller.response.ItemResponse;
import br.com.lp2.core.ports.driver.itemdriver.CreateItemPort;
import br.com.lp2.core.ports.driver.itemdriver.DeleteItemByIdPort;
import br.com.lp2.core.ports.driver.itemdriver.FindItemByIdPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itens")
public record ItemController(
        CreateItemPort createItemPort,
        FindItemByIdPort findItemByIdPort,
        DeleteItemByIdPort deleteItemByIdPort

) {
    @PostMapping
    public ItemResponse post(@RequestBody ItemRequest request){
        var item = request.toItem();
        item = createItemPort.apply(item);
        return  new ItemResponse().fromItem(item);
    }
    @GetMapping("{id}")
    public ItemResponse findById(@PathVariable String id) {
        var item = findItemByIdPort.apply(id);
        return new ItemResponse().fromItem(item);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        deleteItemByIdPort.apply(id);
    }

}
