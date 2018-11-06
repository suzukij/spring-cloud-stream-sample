package com.example.cloudstream;

import com.example.cloudstream.channel.AlphaChannel;
import com.example.cloudstream.channel.BravoChannel;
import com.example.cloudstream.channel.CharlieChannel;
import com.example.cloudstream.channel.DeltaChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = {AlphaChannel.class, BravoChannel.class, CharlieChannel.class, DeltaChannel.class})
public class ProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }

}
