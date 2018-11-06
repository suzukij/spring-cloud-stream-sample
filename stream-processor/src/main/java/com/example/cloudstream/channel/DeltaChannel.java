package com.example.cloudstream.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface DeltaChannel {
    String OUTPUT = "delta";

    @Output(OUTPUT)
    SubscribableChannel output();
}