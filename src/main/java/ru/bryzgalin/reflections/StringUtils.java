package ru.bryzgalin.reflections;

import ru.bryzgalin.annotations.ToString;

import java.lang.reflect.Field;

public class StringUtils {
    public static String toString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        String result = "";

        if (clazz.isAnnotationPresent(ToString.class)) {
            ToString classAnnotation = clazz.getAnnotation(ToString.class);
            if (classAnnotation.value() == ToString.ToStringOption.YES) {
                result += clazz.getSimpleName() + " {";

                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);

                    if (field.isAnnotationPresent(ToString.class)) {
                        ToString fieldAnnotation = field.getAnnotation(ToString.class);
                        if (fieldAnnotation.value() == ToString.ToStringOption.YES) {
                            result += field.getName() + "=" + field.get(object) + ", ";
                        }
                    }
                }

                // Убираем последнюю запятую и пробел, если они есть
                if (result.endsWith(", ")) {
                    result = result.substring(0, result.length() - 2);
                }
                result += "}";
            } else {
                result += clazz.getSimpleName() + " {}";
            }
        } else {
            result += clazz.getSimpleName() + " {}";
        }
        return result;
    }
}
