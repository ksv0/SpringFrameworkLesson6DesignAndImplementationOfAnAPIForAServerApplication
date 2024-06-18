package ru.gb.ksv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.gb.ksv.config.IntegrationConfig;


@SpringBootApplication
@Import(IntegrationConfig.class)
public class Example1Application {

    public static void main(String[] args) {
        SpringApplication.run(Example1Application.class, args);
    }

}
