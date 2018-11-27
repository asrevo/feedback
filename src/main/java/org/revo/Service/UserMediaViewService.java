package org.revo.Service;

import org.revo.Domain.UserMediaView;

import java.util.List;

public interface UserMediaViewService {
    UserMediaView view(String id);

    int countViews(String id);

    List<UserMediaView> views(String id, int size, String lastid);
}
