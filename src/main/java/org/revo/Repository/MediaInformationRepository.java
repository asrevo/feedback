package org.revo.Repository;

import org.revo.Domain.MediaInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MediaInformationRepository extends MongoRepository<MediaInformation, String> {
    Optional<MediaInformation> findByMediaId(String id);
}
