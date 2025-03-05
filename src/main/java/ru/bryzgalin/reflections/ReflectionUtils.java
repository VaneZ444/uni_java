package ru.bryzgalin.reflections;

import ru.bryzgalin.mathematical.Line;
import ru.bryzgalin.mathematical.Point;

import java.lang.reflect.Field;
import java.util.*;

public class ReflectionUtils {
    public static Set<Field> getAllFields(Class<?> cls){
        if(cls.equals(Object.class)) return Set.of();
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

}
