package com.example.calenderprojectjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalenderProjectJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalenderProjectJpaApplication.class, args);
    }

}
