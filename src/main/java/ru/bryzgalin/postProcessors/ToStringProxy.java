package ru.bryzgalin.postProcessors;

import org.springframework.cglib.proxy.Enhancer;
import ru.bryzgalin.annotations.Cache;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class ToStringProxy {
    public static <T> T createToStringProxy(T o) {
        if (o == null) return o;
        if (!o.getClass().isAnnotationPresent(Cache.class)) return o;
        return (T) Enhancer.create(o.getClass(), o.getClass().getInterfaces(), null);
    }
    @Override
    public String toString() {
        return ;
    }
    private static Set<Field> getAllFields(Class<?> cls) {
        if (cls.equals(Object.class)) return Set.of();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(cls.getDeclaredFields()));
        Class<?> clsParent = cls.getSuperclass();
        fields.addAll(getAllFields(clsParent));
        return fields;
    }
}
