package br.com.lp2.core.ports.driver;

import br.com.lp2.core.domain.Item;

public interface CreateItemPort {

    Item apply(Item item);
}
