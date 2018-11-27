package org.revo.Repository;

import org.revo.Domain.Stater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaterRepository extends MongoRepository<Stater, String> {
}
