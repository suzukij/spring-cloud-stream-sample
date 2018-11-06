package com.example.cloudstream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BravoChannel {
    String INPUT = "bravo";

    @Input(INPUT)
    SubscribableChannel input();
}