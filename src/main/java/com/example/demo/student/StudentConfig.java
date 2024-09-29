package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student alamin = new Student(
                    "Al Amin",
                    "alamin@gmail.com",
                    LocalDate.of(1996, Month.SEPTEMBER, 19)
            );
            Student iftekhar = new Student(
                    "Iftekhar",
                    "iftekher@gmail.com",
                    LocalDate.of(1992, Month.SEPTEMBER, 19)
            );
            studentRepository.saveAll(List.of(alamin, iftekhar));
        };
    }
}
