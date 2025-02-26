package ru.bryzgalin.misc.reflections;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import static ru.bryzgalin.misc.reflections.ReflectionUtils.getAllFields;

public abstract class Entity{
    @Override
    public String toString() {
        return "Entity{" +
                getAllFields(this.getClass()).stream()
                        .map(this::getFieldView)
                        .collect(Collectors.joining(", "))
                + "}";
    }

    public String getFieldView(Field field){
        try {
            field.setAccessible(true);
            return field.getName() + " = " + field.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
