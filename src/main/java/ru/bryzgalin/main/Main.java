package ru.bryzgalin.main;

import ru.bryzgalin.reflections.validation.HumanTests;
import ru.bryzgalin.sem1.misc.Human;

import static ru.bryzgalin.reflections.validation.ValidationUtils.validate;

public class Main {
    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        Human h = new Human("Sergey", 750);
        System.out.println(h);
            validate(h, HumanTests.class);
    }
}