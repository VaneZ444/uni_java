package ru.bryzgalin.reflections.validation;

import ru.bryzgalin.annotations.Test;
import ru.bryzgalin.sem1.misc.Human;

public class LongNameValidate {
    public LongNameValidate() {
    }
    @Test
    public void validate(Human human) {
        String value = human.getName();
        if(value == null || value.length() < 2) throw new ValidateException("incorrect name");
    }
}
