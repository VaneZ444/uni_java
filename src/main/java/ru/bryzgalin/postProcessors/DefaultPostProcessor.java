package ru.bryzgalin.postProcessors;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.bryzgalin.annotations.Default;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class DefaultPostProcessor implements BeanPostProcessor {

    private final ConfigurableListableBeanFactory beanFactory;

    public DefaultPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String value) throws BeansException {
        processClassLevelDefaults(bean);
        processFieldLevelDefaults(bean);
        return bean;
    }

    private void processClassLevelDefaults(Object bean) {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            String sourceBeanName = annotation.value();
            if (!sourceBeanName.isEmpty()) {
                Object sourceBean = beanFactory.getBean(sourceBeanName);
                applyClassDefaults(bean, sourceBean);
            }
        }
    }
    private void applyClassDefaults(Object target, Object source) throws BeansException {
        for (Field targetField : getAllFields(target.getClass())) {
            try {
                Method getter = findGetter(source.getClass(), targetField.getName());
                if (getter != null) {
                    targetField.setAccessible(true);
                    targetField.set(target, getter.invoke(source));
                }
            } catch (Exception e) {
                throw new RuntimeException("Error applying defaults for field: " + targetField.getName(), e);
            }
        }
    }

    private void processFieldLevelDefaults(Object bean) {
        for (Field field : getAllFields(bean.getClass())) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                String sourceBeanName = annotation.value();
                if (!sourceBeanName.isEmpty()) {
                    Object sourceBean = beanFactory.getBean(sourceBeanName);
                    setFieldValue(bean, field, sourceBean);
                }
            }
        }
    }

    private Method findGetter(Class<?> clazz, String fieldName) {
        try {
            return clazz.getMethod("get" + capitalize(fieldName));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    private void setFieldValue(Object bean, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(bean, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to set field: " + field.getName(), e);
        }
    }
}