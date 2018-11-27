package org.revo.Service;

import org.revo.Domain.UserMediaComment;
import org.revo.Domain.UserMediaLike;
import org.revo.Domain.UserMediaView;

public interface UserMediaEventListener {

    void AfterSaveUserMediaLike(UserMediaLike event);

    void AfterSaveUserMediaView(UserMediaView event);

    void AfterSaveUserMediaComment(UserMediaComment event);
}