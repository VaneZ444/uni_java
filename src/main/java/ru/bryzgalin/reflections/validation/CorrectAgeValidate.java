package ru.bryzgalin.reflections.validation;

public class CorrectAgeValidate {
    public CorrectAgeValidate() {
    }

    public void validate(int age) {
        if(age < 0) throw new ValidateException("incorrect name");
    }
}
