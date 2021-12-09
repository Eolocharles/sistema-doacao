package br.com.lp2.core.us;

import br.com.lp2.core.domain.Item;
import br.com.lp2.core.ports.driven.repository.ItemRepositoryPort;
import br.com.lp2.core.ports.driver.CreateItemPort;
import org.springframework.stereotype.Service;

@Service
public record CreateItemUS(ItemRepositoryPort repository)implements CreateItemPort {

    @Override
    public Item apply(Item item){
        return repository.save(item);
    }
}
