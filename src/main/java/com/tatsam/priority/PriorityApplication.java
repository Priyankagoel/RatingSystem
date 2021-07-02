package com.tatsam.priority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication(scanBasePackages = {"com.tatsam.priority.*"})
public class PriorityApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriorityApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
