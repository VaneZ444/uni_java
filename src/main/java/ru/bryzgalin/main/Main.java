package ru.bryzgalin.main;

import ru.bryzgalin.examPrep.first.trafficLightTask.TrafficLight;
import ru.bryzgalin.examPrep.first.trafficLightTask.YellowToYellow;

public class Main {
    public static void main(String[] args) {
        TrafficLight tf = new TrafficLight();
        tf.next(); //выведет зеленый
        tf.next(); //выведет желтый
        tf.next(); //выведет красный
        tf.next(); //выведет желтый
        tf.next(); //выведет зеленый
        tf.next(); //выведет желтый
        tf.setState(YellowToYellow.getInstance());
        System.out.println("ночь пришла");
        tf.next(); //выведет желтый
        tf.next(); //выведет желтый
        tf.next(); //выведет желтый
    }
}