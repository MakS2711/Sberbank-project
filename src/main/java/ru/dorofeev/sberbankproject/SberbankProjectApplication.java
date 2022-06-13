package ru.dorofeev.sberbankproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SberbankProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SberbankProjectApplication.class, args);
    }

}
