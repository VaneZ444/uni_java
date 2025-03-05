package ru.bryzgalin.reflections.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValidationUtils {
    public static void validate(Object object, Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        Object testObj;
        try {
            Constructor<?> constructor = null;
            constructor = testClass.getDeclaredConstructor();
            testObj = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Method method : methods) {
            //if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(testObj.getClass())) {
                try {
                    method.setAccessible(true);
                    method.invoke(testObj, object);
                } catch (InvocationTargetException e) {
                    //System.out.println(e);
                    Throwable cause = e.getCause();
                    if (cause instanceof ValidateException) {
                        throw (ValidateException) cause;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Ошибка доступа к методу: " + method.getName(), e);
                }
           // }
        }
    }
}
