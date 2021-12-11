package br.com.lp2.core.ports.driver.itemdriver;

import br.com.lp2.core.domain.Item;

public interface FindItemByIdPort {

    Item apply(String id);
}
