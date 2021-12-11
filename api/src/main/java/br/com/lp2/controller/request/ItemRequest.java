package br.com.lp2.controller.request;

import br.com.lp2.core.domain.Item;
import lombok.Setter;

@Setter
public class ItemRequest {

    private String describe;
    private String img;
    private String status;

    public Item toItem(){
        var item = new Item();
        item.setDescribe(describe);
        item.setImg(img);
        item.setStatus(status);

        return  item;
    }
}
