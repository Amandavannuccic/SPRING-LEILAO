package com.amanda.spring_leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringLeilaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLeilaoApplication.class, args);
    }
}