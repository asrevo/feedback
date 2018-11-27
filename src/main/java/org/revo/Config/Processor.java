package org.revo.Config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Processor {
    String ToFeedBack_pop = "ToFeedBack_pop";

    @Input("ToFeedBack_pop")
    MessageChannel ToFeedBack_pop();
}
