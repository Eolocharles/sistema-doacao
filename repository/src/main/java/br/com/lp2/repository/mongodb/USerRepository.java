package br.com.lp2.repository.mongodb;

import br.com.lp2.core.domain.User;
import br.com.lp2.core.ports.driven.repository.userRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface USerRepository extends MongoRepository<User, String>, userRepositoryPort {
}
