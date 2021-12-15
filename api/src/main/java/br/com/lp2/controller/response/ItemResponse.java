package br.com.lp2.controller.response;

import br.com.lp2.core.domain.Item;
import br.com.lp2.core.domain.User;
import lombok.Getter;

@Getter
public class ItemResponse {

    private String id;
    private String describe;
    private String img;
    private String status;
    private UserResponse user;

    public ItemResponse fromItem(Item item, UserResponse user){
        this.id = item.getId();
        this.describe = item.getDescribe();
        this.img = item.getImg();
        this.status = item.getStatus();
        this.user = user;

        return  this;
    }
}
