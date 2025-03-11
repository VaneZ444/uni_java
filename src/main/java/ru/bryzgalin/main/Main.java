package ru.bryzgalin.main;

import ru.bryzgalin.annotations.Default;
import ru.bryzgalin.annotations.Invoke;
import ru.bryzgalin.reflections.validation.ValidationUtils;
import ru.bryzgalin.sem1.misc.Human;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        Human h = new Human("sergey", 18);

        for (Method method : Human.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


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
    }
}