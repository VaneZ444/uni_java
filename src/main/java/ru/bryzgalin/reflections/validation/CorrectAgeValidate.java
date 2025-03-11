package ru.bryzgalin.reflections.validation;

import ru.bryzgalin.annotations.Test;
import ru.bryzgalin.sem1.misc.Human;

public class CorrectAgeValidate {
    public CorrectAgeValidate() {
    }
    @Test
    public void validate(Human human) {
        int age = human.getAge();
        if(age < 0) throw new ValidateException("incorrect age:" + age);
    }
}
