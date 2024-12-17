package ru.bryzgalin.examPrep.first.trafficLightTask;

public class YellowToYellow implements TrafficLightState {
    private static final YellowToYellow INSTANCE = new YellowToYellow();

    private YellowToYellow() {}

    public static YellowToYellow getInstance() {
        return INSTANCE;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Желтый");
        trafficLight.setState(YellowToYellow.getInstance());
    }
}