package ru.bryzgalin.main;

import ru.bryzgalin.reflections.ReflectionUtils;
import ru.bryzgalin.sem1.animals.Parrot;
import ru.bryzgalin.sem1.misc.Human;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {

        System.out.println(ReflectionUtils.collect(List.of(Human.class, Parrot.class)));

        /*
        for (Field field : h.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                Class<?> type = annotation.value();
                field.setAccessible(true);

                if (type == String.class) {
                    field.set(h, "ivan"); // Пустая строка для String
                } else if (type == Integer.class || type == int.class) {
                    field.set(h, -20);
                }
            }
        }

        ValidationUtils.validate(h);

         */
    }
}