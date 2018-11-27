package org.revo.Service;

import org.revo.Domain.UserMediaComment;

import java.util.List;

public interface UserMediaCommentService {
    UserMediaComment comment(String id, String message);

    void uncomment(String id);

    List<UserMediaComment> comments(String id);

    int countComments(String id);
}
