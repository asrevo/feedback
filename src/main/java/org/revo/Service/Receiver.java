package org.revo.Service;

import org.revo.Config.Processor;
import org.revo.Domain.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

import java.io.IOException;

/**
 * Created by ashraf on 23/04/17.
 */
@MessageEndpoint
public class Receiver {
    @Autowired
    private MasterService masterService;

    @StreamListener(value = Processor.feedback_index)
    public void receive(Message<Master> master) throws IOException {
        masterService.index(master.getPayload());
    }
}