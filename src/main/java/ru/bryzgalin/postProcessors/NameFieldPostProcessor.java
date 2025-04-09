package ru.bryzgalin.postProcessors;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class NameFieldPostProcessor implements BeanPostProcessor {
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Field> fields = List.of(bean.getClass().getDeclaredFields());
        for(Field field : fields){
            if ("name".equals(field.getName()) && field.getType() == String.class){
                field.setAccessible(true);
                String val = (String) field.get(bean);

                if (val == null){
                    field.set(bean, "vasia");
                    System.out.println("vasia set for " + beanName);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
