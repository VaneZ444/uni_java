package ru.bryzgalin.reflections.validation;

import lombok.SneakyThrows;
import ru.bryzgalin.annotations.Invoke;
import ru.bryzgalin.annotations.Validate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ValidationUtils {

    @SneakyThrows
    public static void validate(Object object) {
        Class<?> clazz = object.getClass();

        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate validateAnnotation = clazz.getAnnotation(Validate.class);
            Class<?>[] validatorClasses = validateAnnotation.value();
            for (Class<?> validatorClass : validatorClasses) {
                validate(object, validatorClass);
            }
        } else {
            throw new ValidateException("no validators for class " + clazz.getSimpleName());
        }
    }

    @SneakyThrows
    public static void validate(Object object, Class<?> testClass) {

        Constructor<?> constructor = testClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object testObj = constructor.newInstance();

        List<Method> tests = Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> m.getParameterCount() == 1)
                .filter(m -> m.getParameterTypes()[0].isAssignableFrom(object.getClass()))
                .peek(m -> m.setAccessible(true))
                .toList();

        for (Method method : tests) {
            try {
                method.invoke(testObj, object);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof ValidateException ve) {
                    throw ve;
                }
                throw new RuntimeException(e);
            }
        }
    }
}
