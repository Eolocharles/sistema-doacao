package br.com.lp2.core.ports.driven.repository;

import br.com.lp2.core.domain.Item;
import br.com.lp2.core.domain.User;

import java.util.Optional;

public interface ItemRepositoryPort {

    Item save(Item item);

    Optional<Item> findById(String id);

    void deleteById(String id);
}
