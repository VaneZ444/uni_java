package ru.bryzgalin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bryzgalin.postProcessors.TestBean;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.bryzgalin");
        TestBean beanWithName = context.getBean(TestBean.class);
        System.out.println("TestBeanWithName.name: " + beanWithName.getName());
    }
}