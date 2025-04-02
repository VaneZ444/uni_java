package ru.bryzgalin.sem1.examPrep.third.traffic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrafficLightConfig {

    // 1. Сначала создаем все цвета без зависимостей
    @Bean
    public TrafficLightColour redColour() {
        TrafficLightColour red = new TrafficLightColour();
        red.setColour("red");
        return red;
    }

    @Bean
    public TrafficLightColour redToYellowColour() {
        TrafficLightColour ry = new TrafficLightColour();
        ry.setColour("yellow(from red)");
        return ry;
    }

    @Bean
    public TrafficLightColour greenColour() {
        TrafficLightColour green = new TrafficLightColour();
        green.setColour("green");
        return green;
    }

    @Bean
    public TrafficLightColour yellowColour() {
        TrafficLightColour yellow = new TrafficLightColour();
        yellow.setColour("yellow");
        return yellow;
    }

    // 2. Затем настраиваем связи между ними
    @Bean
    public Object configureTransitions() {
        redColour().setNextColour(redToYellowColour());
        redToYellowColour().setNextColour(greenColour());
        greenColour().setNextColour(yellowColour());
        yellowColour().setNextColour(redColour());
        return null; // Этот бин не используется, нужен только для настройки
    }

    // 3. Создаем светофор
    @Bean
    public TrafficLight trafficLight() {
        return new TrafficLight(redColour());
    }
}