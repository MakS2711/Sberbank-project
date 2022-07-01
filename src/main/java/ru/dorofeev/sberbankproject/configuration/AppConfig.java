package ru.dorofeev.sberbankproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@Configuration
public class AppConfig {
    @Value("${cds.endpoint.save.target}")
    private String uri;

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(uri)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
