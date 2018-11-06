package com.example.cloudstream;

import com.example.cloudstream.channel.DeltaChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.HttpEntity;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Component
public class SinkListener {

    @Autowired
    private RestTemplate restTemplate;

    @StreamListener(DeltaChannel.INPUT)
    public void receiveDelta(Message<Map<String, Object>> message) {
        log.info("receiveDelta: {}", message);
        restTemplate.postForEntity("http://localhost:8080/notify", new HttpEntity(message.getPayload()), String.class);
    }

}