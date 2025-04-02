package ru.bryzgalin.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    public String helloBean() {
        return "Hello world";
    }

    @Bean
    @Scope("prototype")
    public RandProvider randProvider(
            @Qualifier("min") int min,
            @Qualifier("max") int max
    ) {
        return new RandProvider(min, max);
    }

    @Bean
    public Date firstCall() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return num -> num >= 2 && num <= 5;
    }

    @Bean(name = "min")
    public int min() {
        return 1;
    }

    @Bean(name = "max")
    public int max() {
        return 5;
    }
}
