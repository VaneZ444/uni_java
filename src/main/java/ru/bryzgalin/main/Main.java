package ru.bryzgalin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bryzgalin.sem1.examPrep.third.traffic.TrafficLight;
import ru.bryzgalin.sem1.examPrep.third.traffic.TrafficLightConfig;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        var context = new AnnotationConfigApplicationContext(TrafficLightConfig.class);
        TrafficLight trafficLight = context.getBean(TrafficLight.class);

        for (int i = 0; i < 6; i++) {
            trafficLight.next();
        }
    }
}