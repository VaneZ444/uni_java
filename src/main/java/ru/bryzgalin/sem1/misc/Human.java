package ru.bryzgalin.sem1.misc;

import ru.bryzgalin.annotations.Default;
import ru.bryzgalin.annotations.Invoke;
import ru.bryzgalin.annotations.ToString;
import ru.bryzgalin.annotations.Validate;
import ru.bryzgalin.reflections.validation.CorrectAgeValidate;
import ru.bryzgalin.reflections.validation.LongNameValidate;

@Validate({CorrectAgeValidate.class, LongNameValidate.class})
@ToString
public class Human {
    @ToString(ToString.ToStringOption.YES)
    @Default(String.class)
    private String name;
    @ToString(ToString.ToStringOption.NO)
    @Default(int.class)
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Human(String params) {
        String[] parts = params.split(" ");
        this.name = parts[0];
        this.age = Integer.parseInt(parts[1]);
    }
    @Override
    @Invoke
    public String toString() {
        return name + " " + age;
    }

    public String getName() {
        return name;
    }

    @Invoke
    public void greet() {
        System.out.println("hi im " + this.name);
    }

    public int getAge() {
        return age;
    }
}