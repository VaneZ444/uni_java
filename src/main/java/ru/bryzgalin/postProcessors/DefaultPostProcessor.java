package ru.bryzgalin.postProcessors;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.bryzgalin.annotations.Default;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanCreationException {
        if (hasDefaultAnnotation(bean.getClass())) reset(bean);
        return bean;
    }

    private boolean hasDefaultAnnotation(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Default.class)) return true;
        return Arrays.stream(clazz.getDeclaredFields())
                .anyMatch(f -> f.isAnnotationPresent(Default.class));
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(clazz, fields::add);
        return fields;
    }

    private void reset(Object target) {
        Class<?> targetClass = target.getClass();

        //аннотация на классе
        Optional.ofNullable(targetClass.getAnnotation(Default.class))
                .ifPresent(classAnnotation -> {
                    String providerName = classAnnotation.value();
                    Object provider = applicationContext.getBean(providerName);
                    applyClassDefaults(target, provider);
                });

        //аннотации на поле
        getAllFields(targetClass).stream()
                .filter(field -> field.isAnnotationPresent(Default.class))
                .forEach(field -> resetField(target, field));
    }

    private void applyClassDefaults(Object target, Object provider) {
        getAllFields(target.getClass()).forEach(field -> {
            try {
                String getterName = assembleGetterName(field.getName());
                Method getter = findMethod(provider.getClass(), getterName);

                if (getter != null) {
                    Object defaultValue = getter.invoke(provider);
                    setFieldValue(target, field, defaultValue);
                }
            } catch (Exception e) {
                throw new BeanCreationException("failed to apply default for field: " + field.getName(), e);
            }
        });
    }

    private void resetField(Object target, Field field) throws BeanCreationException {
        try {
            String providerName = field.getAnnotation(Default.class).value();
            Object defaultValue = applicationContext.getBean(providerName);
            setFieldValue(target, field, defaultValue);
        } catch (BeanCreationException e) {
            throw new BeanCreationException("failed to set default value for field: " + field.getName(), e);
        }
    }

    private void setFieldValue(Object target, Field field, Object value) throws BeanCreationException {
        try {
            field.setAccessible(true);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            throw new BeanCreationException("failed to set field value: " + field.getName(), e);
        }
    }

    private Method findMethod(Class<?> clazz, String methodName) {
        try {
            return clazz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private String assembleGetterName(String str) {
        if (str == null || str.isEmpty()) return str;
        return "get" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeanCreationException {
        this.applicationContext = applicationContext;
    }
}