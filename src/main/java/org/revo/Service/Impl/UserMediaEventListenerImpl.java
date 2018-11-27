package org.revo.Service.Impl;

import org.revo.Domain.MediaInformation;
import org.revo.Domain.UserMediaComment;
import org.revo.Domain.UserMediaLike;
import org.revo.Domain.UserMediaView;
import org.revo.Service.Cached.MediaInformationCachedService;
import org.revo.Service.MediaInformationService;
import org.revo.Service.UserMediaEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMediaEventListenerImpl implements UserMediaEventListener {
    @Autowired
    private MediaInformationService mediaInformationService;
    @Autowired
    private MediaInformationCachedService mediaInformationCachedService;

    @Override
    public void AfterSaveUserMediaLike(UserMediaLike event) {
        MediaInformation mediaInformation = mediaInformationService.findByMediaId(event.getMediaId())
                .map(MediaInformation::incLikes)
                .orElseGet(() -> new MediaInformation().incLikes());
        mediaInformationCachedService.update(mediaInformationService.save(mediaInformation));
    }

    @Override
    public void AfterSaveUserMediaView(UserMediaView event) {
        MediaInformation mediaInformation = mediaInformationService.findByMediaId(event.getMediaId())
                .map(MediaInformation::incViews)
                .orElseGet(() -> new MediaInformation(event.getMediaId()).incViews());
        mediaInformationCachedService.update(mediaInformationService.save(mediaInformation));
    }

    @Override
    public void AfterSaveUserMediaComment(UserMediaComment event) {
        MediaInformation mediaInformation = mediaInformationService.findByMediaId(event.getMediaId())
                .map(MediaInformation::incComments)
                .orElseGet(() -> new MediaInformation().incComments());
        mediaInformationCachedService.update(mediaInformationService.save(mediaInformation));
    }
}