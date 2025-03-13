package ru.bryzgalin.reflections;

import lombok.SneakyThrows;
import ru.bryzgalin.annotations.Invoke;
import ru.bryzgalin.sem1.mathematical.Line;
import ru.bryzgalin.sem1.mathematical.Point;
import ru.bryzgalin.sem1.misc.Human;

import javax.management.ReflectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ReflectionUtils {
    public static Set<Field> getAllFields(Class<?> cls) {
        if (cls.equals(Object.class)) return Set.of();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(cls.getDeclaredFields()));
        Class<?> clsParent = cls.getSuperclass();
        fields.addAll(getAllFields(clsParent));
        return fields;
    }

    public static void lineConnector(Line<Point> line1, Line<Point> line2) throws IllegalAccessException, NoSuchFieldException {
        Field endField = Line.class.getDeclaredField("a");
        endField.setAccessible(true);
        Point endPoint = (Point) endField.get(line1);
        Field startField = Line.class.getDeclaredField("b");
        startField.setAccessible(true);
        startField.set(line2, endPoint);
    }
    @SneakyThrows
    public static Map<String, Object> collect(List<Class<?>> classes) {
        Map<String, Object> result = new HashMap<>();
        for (Class<?> clazz : classes) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (!method.isAnnotationPresent(Invoke.class)) continue;
                if (method.getParameterCount() != 0) continue;
                if (method.getReturnType().equals(void.class)) continue;

                method.setAccessible(true);

                Object instance = null;
                if (!Modifier.isStatic(method.getModifiers())) {
                    try {
                        instance = clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        continue;
                    }
                }

                Object value = method.invoke(instance);
                result.put(method.getName(), value);
            }
        }
        return result;
    }
}
