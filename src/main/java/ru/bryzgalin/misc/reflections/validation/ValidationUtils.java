package ru.bryzgalin.misc.reflections.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValidationUtils {
    public static void validate(Object object, Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.invoke(null, object);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof ValidateException) {
                    throw (ValidateException) cause;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Ошибка доступа к методу: " + method.getName(), e);
            }
        }
    }
}
