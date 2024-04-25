package com.example.hlhwsaver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HlhwsaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlhwsaverApplication.class, args);
    }

}
