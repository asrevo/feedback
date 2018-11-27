package org.revo.Service.Impl;

import org.revo.Domain.UserMediaLike;
import org.revo.Repository.UserMediaLikeRepository;
import org.revo.Service.Cached.UserMediaLikeCachedService;
import org.revo.Service.UserMediaEventListener;
import org.revo.Service.UserMediaLikeService;
import org.revo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMediaLikeServiceImpl implements UserMediaLikeService {
    @Autowired
    private UserMediaLikeRepository userMediaLikeRepository;
    @Autowired
    private UserMediaLikeCachedService userMediaLikeCachedService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMediaEventListener userMediaEventListener;

    @Override
    public boolean liked(String id) {
        return userMediaLikeRepository.findByUserIdAndMediaId(userService.current().get(), id).isPresent();
    }

    @Override
    public void unlike(String id) {
        userMediaLikeRepository.deleteByMediaIdAndUserId(id, userService.current().get());
        userMediaLikeCachedService.decLikes(id);
    }

    @Override
    public UserMediaLike like(String id) {
        return userMediaLikeRepository.findByUserIdAndMediaId(userService.current().get(), id).orElseGet(() -> {
            UserMediaLike save = userMediaLikeRepository.save(UserMediaLike.builder().mediaId(id).build());
            userMediaLikeCachedService.incLikes(id);
            userMediaEventListener.AfterSaveUserMediaLike(save);
            return save;
        });
    }

    @Override
    public int countLikes(String id) {
        return userMediaLikeRepository.countByMediaId(id);
    }
}