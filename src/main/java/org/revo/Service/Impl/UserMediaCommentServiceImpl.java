package org.revo.Service.Impl;

import org.revo.Domain.UserMediaComment;
import org.revo.Repository.UserMediaCommentRepository;
import org.revo.Service.Cached.UserMediaCommentCachedService;
import org.revo.Service.UserMediaCommentService;
import org.revo.Service.UserMediaEventListener;
import org.revo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMediaCommentServiceImpl implements UserMediaCommentService {
    @Autowired
    private UserMediaCommentRepository userMediaCommentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMediaCommentCachedService userMediaCommentCachedService;
    @Autowired
    private UserMediaEventListener userMediaEventListener;

    @Override
    public UserMediaComment comment(String id, String message) {
        UserMediaComment userMediaComment = new UserMediaComment();
        userMediaComment.setMediaId(id);
        userMediaComment.setMessage(message);
        UserMediaComment save = userMediaCommentRepository.save(userMediaComment);
        userMediaEventListener.AfterSaveUserMediaComment(userMediaComment);
        userMediaCommentCachedService.incComments(id);
        return save;
    }

    @Override
    public void uncomment(String id) {
        userMediaCommentRepository.deleteByIdAndUserId(id, userService.current().get());
        userMediaCommentCachedService.decComments(id);

    }

    @Override
    public List<UserMediaComment> comments(String id) {
        return userMediaCommentRepository.findAllByMediaId(id);
    }

    @Override
    public int countComments(String id) {
        return userMediaCommentRepository.countByMediaId(id);
    }
}
