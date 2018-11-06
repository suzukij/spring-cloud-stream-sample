package com.example.cloudstream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AlphaChannel {
    String INPUT = "alpha";

    @Input(INPUT)
    SubscribableChannel input();
}