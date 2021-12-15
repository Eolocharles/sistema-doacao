package br.com.lp2.controller.request;

import br.com.lp2.core.domain.Item;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class ItemRequest {

    private String describe;
    private String img;
    private String status;
    private ObjectId userId;

    public Item toItem(){
        var item = new Item();
        item.setDescribe(describe);
        item.setImg(img);
        item.setStatus(status);
        item.setUserId(userId);

        return  item;
    }
}
