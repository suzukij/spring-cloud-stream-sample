package com.example.cloudstream;

import com.example.cloudstream.channel.AlphaChannel;
import com.example.cloudstream.channel.BravoChannel;
import com.example.cloudstream.channel.CharlieChannel;
import com.example.cloudstream.channel.DeltaChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SampleListener {

    @StreamListener(AlphaChannel.INPUT)
    @SendTo(DeltaChannel.OUTPUT)
    public Map<String, Object> processAlpha(Message<Map<String, Object>> message) {
        log.info("processAlpha: {}", message);
        return message.getPayload();
    }

    @StreamListener(BravoChannel.INPUT)
    @SendTo(DeltaChannel.OUTPUT)
    public Map<String, Object> processBravo(Message<Map<String, Object>> message) {
        log.info("processBravo: {}", message);
        return message.getPayload();
    }

    @StreamListener(CharlieChannel.INPUT)
    @SendTo(DeltaChannel.OUTPUT)
    public Map<String, Object> processCharlie(Message<Map<String, Object>> message) {
        log.info("processCharlie: {}", message);

        if (true) {
            throw new RuntimeException("retry demo");
        }
        return message.getPayload();
    }

}
