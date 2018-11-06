package com.example.cloudstream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CharlieChannel {
    String INPUT = "charlie";

    @Input(INPUT)
    SubscribableChannel input();
}