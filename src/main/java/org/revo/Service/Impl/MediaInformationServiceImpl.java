package org.revo.Service.Impl;

import org.revo.Domain.MediaInformation;
import org.revo.Repository.MediaInformationRepository;
import org.revo.Service.MediaInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

@Service
public class MediaInformationServiceImpl implements MediaInformationService {
    @Autowired
    private MediaInformationRepository mediaInformationRepository;

    @Override
    public Optional<MediaInformation> findByMediaId(String mediaId) {
        return mediaInformationRepository.findByMediaId(mediaId);
    }

    @Override
    public MediaInformation save(MediaInformation mediaInformation) {
        return mediaInformationRepository.save(mediaInformation);
    }

    @Override
    public List<MediaInformation> findAll() {
        return mediaInformationRepository.findAll();
    }
}
