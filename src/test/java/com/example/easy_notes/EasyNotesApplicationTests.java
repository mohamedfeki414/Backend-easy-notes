package com.example.easy_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // Active l'audit pour les entités JPA
public class EasyNotesApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(EasyNotesApplication.class, args);
    }
}