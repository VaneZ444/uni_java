package ru.bryzgalin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bryzgalin.sem1.misc.Student;
import java.util.function.Predicate;

@Configuration
public class StudentConfig {

    // Используем бин range из задачи 9.1.4
    @Bean
    public Student student1(Predicate<Integer> range) {
        return new Student("Иванов Иван", range, 4, 5, 3);
    }

    @Bean
    public Student student2(Predicate<Integer> range) {
        return new Student("Петрова Мария", range, 3, 4, 5, 2);
    }
}