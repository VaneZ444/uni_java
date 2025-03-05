package ru.bryzgalin.reflections.validation;

import ru.bryzgalin.sem1.misc.Human;

public class HumanTests {
    public HumanTests() {
    }
    void testAgeRange(Human human) {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new ValidateException("ошибка в testAgeRange: возраст человека не в диапазоне от 1 до 200");
        }
    }

    void testNameLength(Human human) {
        if (human.getName().length() < 2 || human.getName().length() > 100) {
            throw new ValidateException("ошибка в testNameLength: длина имени должна быть от 2 до 100 символов");
        }
    }
}
