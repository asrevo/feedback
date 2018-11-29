package org.revo.Config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Processor {
    String feedBack_queue = "feedBack_queue";

    @Input("feedBack_queue")
    SubscribableChannel feedBack_queue();
}
