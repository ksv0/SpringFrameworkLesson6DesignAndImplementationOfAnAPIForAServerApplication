package com.example.example4sem6_rick_and_morty_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Example4sem6RickAndMortyRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(Example4sem6RickAndMortyRestApplication.class, args);
    }
}
