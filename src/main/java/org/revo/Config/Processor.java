package org.revo.Config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Processor {
    String feedback_queue = "feedback_queue";

    @Input("feedback_queue")
    SubscribableChannel feedback_queue();
}
