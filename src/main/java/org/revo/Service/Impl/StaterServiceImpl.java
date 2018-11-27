package org.revo.Service.Impl;

import org.revo.Domain.Stater;
import org.revo.Repository.StaterRepository;
import org.revo.Service.StaterService;
import org.revo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class StaterServiceImpl implements StaterService {
    @Autowired
    private StaterRepository staterRepository;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private UserService userService;

    @Override
    public Stater state(Stater stater) {
        return staterRepository.save(stater);
    }

    @Override
    public List<Stater> states() {
//        TypedAggregation<Stater> aggregation = newAggregation(Stater.class,
//                group("mediaId")
//                        .last("id").as("id")
//                        .last("createdDate").as("createdDate")
//                        .last("mediaId").as("mediaId")
//                        .last("userId").as("userId")
//                        .last("queue").as("queue")
//                        .last("state").as("state"),
//                match(where("userId").is(userService.current().get()))
//        );
//        return mongoOperations.aggregate(aggregation, Stater.class).getMappedResults();
        return Collections.emptyList();
    }
}
