package org.revo.Service;

import org.revo.Domain.UserUserFollow;

import java.util.List;

public interface UserUserFollowService {
    int Followers(String id);

    int Following(String id);

    UserUserFollow follow(String id);

    void unfollow(String id);

    List<UserUserFollow> followers(String id);

    List<UserUserFollow> following(String id);

    boolean followed(String id);

}
