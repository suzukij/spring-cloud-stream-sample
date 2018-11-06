package com.example.cloudstream;

import com.example.cloudstream.channel.DeltaChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBinding(value = {DeltaChannel.class})
public class SinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
