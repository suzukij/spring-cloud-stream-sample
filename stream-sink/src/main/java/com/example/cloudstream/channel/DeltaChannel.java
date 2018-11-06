package com.example.cloudstream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface DeltaChannel {
    String INPUT = "delta";

    @Input("delta")
    SubscribableChannel input();
}
