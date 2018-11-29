package org.revo.Service;

import org.revo.Config.Processor;
import org.revo.Domain.Stater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

/**
 * Created by ashraf on 23/04/17.
 */
@MessageEndpoint
public class Receiver {
    @Autowired
    private StaterService staterService;

    @StreamListener(value = Processor.feedBack_queue)
    public void receive(Message<Stater> stater) {
        staterService.state(stater.getPayload());
    }
}