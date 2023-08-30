package com.easycontrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.easycontrat")
public class EasyContratApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyContratApplication.class, args);
    }
}
