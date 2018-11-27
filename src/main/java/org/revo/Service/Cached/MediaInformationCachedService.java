package org.revo.Service.Cached;

import org.revo.Domain.MediaInformation;

import java.util.List;

public interface MediaInformationCachedService {
    MediaInformation get(String mediaId);

    MediaInformation update(MediaInformation mediaInformation);

    List<MediaInformation> trending(int size);

    void trending();
}
