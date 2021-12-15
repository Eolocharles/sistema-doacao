package br.com.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class Item {

    private String id;
    private String describe;
    private String img;
    private String status;
    private ObjectId userId;
}
