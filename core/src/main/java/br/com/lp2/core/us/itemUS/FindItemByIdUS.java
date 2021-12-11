package br.com.lp2.core.us.itemUS;

import br.com.lp2.core.domain.Item;
import br.com.lp2.core.ports.driven.repository.ItemRepositoryPort;
import br.com.lp2.core.ports.driver.itemdriver.FindItemByIdPort;
import org.springframework.stereotype.Service;

@Service
public record FindItemByIdUS(ItemRepositoryPort repository)implements FindItemByIdPort {

    @Override
    public Item apply(String id){
        return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Item not found"));
    }
}
