package org.revo.Service;

import org.revo.Domain.UserMediaLike;

public interface UserMediaLikeService {
    boolean liked(String id);

    void unlike(String id);

    UserMediaLike like(String id);

    int countLikes(String id);
}
