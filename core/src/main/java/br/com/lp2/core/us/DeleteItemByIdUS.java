package br.com.lp2.core.us;

import br.com.lp2.core.ports.driven.repository.ItemRepositoryPort;
import br.com.lp2.core.ports.driver.DeleteItemByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteItemByIdUS(ItemRepositoryPort repository)implements DeleteItemByIdPort {

    @Override
    public void apply(String id){
        repository.deleteById(id);
    }
}
