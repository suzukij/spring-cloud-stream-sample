package com.example.cloudstream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
public class MessageController {
    
    private BinderAwareChannelResolver resolver;

    public MessageController(BinderAwareChannelResolver resolver) {
        this.resolver = resolver;
    }

    @GetMapping("send/{target}")
    public Map sendMessage(@PathVariable String target) {
        Map<String, Object> payload = Collections.singletonMap("target", target);
        sendMessage(target, payload);
        return payload;
    }

    @PostMapping("notify")
    public void notify(@RequestBody Map<String, String> body) {
        log.info("received: {}", body);
    }

    /**
     * dynamically bound destinations
     *
     * @param target
     * @param payload
     */
    public void sendMessage(String target, Object payload) {
        resolver.resolveDestination(target).send(MessageBuilder.withPayload(payload).build());
        log.info("sendMessage: {}", payload);
    }

}
