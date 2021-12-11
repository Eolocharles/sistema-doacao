package br.com.lp2.repository.mongodb;

import br.com.lp2.core.domain.Item;
import br.com.lp2.core.ports.driven.repository.ItemRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>, ItemRepositoryPort {
}
