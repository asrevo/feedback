package org.revo.Repository;

import org.revo.Domain.UserMediaComment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMediaCommentRepository extends MongoRepository<UserMediaComment, String> {
    void deleteByIdAndUserId(String id, String user);

    List<UserMediaComment> findAllByMediaId(String id);

    int countByMediaId(String id);
}
