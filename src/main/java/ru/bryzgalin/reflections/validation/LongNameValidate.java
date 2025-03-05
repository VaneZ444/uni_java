package ru.bryzgalin.reflections.validation;

public class LongNameValidate {
    public LongNameValidate() {
    }

    public void validate(String value) {
        if(value == null || value.length() < 3) throw new ValidateException("incorrect name");
    }
}
