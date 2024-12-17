package ru.bryzgalin.examPrep.first.trafficLightTask;

class YellowToRed implements TrafficLightState {
    private static final YellowToRed INSTANCE = new YellowToRed();

    private YellowToRed() {}

    public static YellowToRed getInstance() {
        return INSTANCE;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Желтый");
        trafficLight.setState(RedToYellow.getInstance());
    }
}