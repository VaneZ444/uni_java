package ru.bryzgalin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bryzgalin.sem1.misc.Student;
import java.util.function.Predicate;

@Component
public class StudentBuilder {
    private final Predicate<Integer> markValidationRule;

    @Autowired
    public StudentBuilder(Predicate<Integer> markValidationRule) {
        this.markValidationRule = markValidationRule;
    }

    public Student createStudent(String name, Integer... marks) {
        return new Student(name, markValidationRule, marks);
    }

    public Student createStudent(String name) {
        return new Student(name, markValidationRule);
    }
}