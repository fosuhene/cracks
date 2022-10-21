package com.fosuhene.cracks.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                 Student fosuhene = new Student(
                            "Fosuhene",
                            "Andrews",
                            "fosuheneandrews@gmail.com",
                            LocalDate.of(2000, JANUARY, 5),
                            LocalDate.of(2015, MARCH, 16),
                         "Male"
                    );
                 Student esther = new Student(
                            "Esther",
                            "Agyemang",
                            "esagyemang@hotmail.com",
                            LocalDate.of(1995, JANUARY, 15),
                         LocalDate.of(2018, JULY, 21),
                         "Female"
                    );

            Student kofi = new Student(
                    "Kofi",
                    "Fosuhene",
                    "kofi@hotmail.com",
                    LocalDate.of(2016, JANUARY, 24),
                    LocalDate.of(2020, SEPTEMBER, 1),
                    "Male"
            );

            Student akwasi = new Student(
                    "Akwasi",
                    "Fosuhene-Jethro",
                    "akwasi@gmail.com",
                    LocalDate.of(2018, DECEMBER, 24),
                    LocalDate.of(2021, MAY, 3),
                    "Male"
            );

                 //save students into db using savall passing list of objects
            repository.saveAll(
                        List.of(fosuhene, esther, kofi, akwasi)
                    );
        };
    }
}
