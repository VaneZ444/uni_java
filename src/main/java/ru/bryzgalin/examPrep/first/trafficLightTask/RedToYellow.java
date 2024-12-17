package ru.bryzgalin.examPrep.first.trafficLightTask;

class RedToYellow implements TrafficLightState {
    private static final RedToYellow INSTANCE = new RedToYellow();

    private RedToYellow() {}

    public static RedToYellow getInstance() {
        return INSTANCE;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Красный");
        trafficLight.setState(YellowToGreen.getInstance());
    }
}