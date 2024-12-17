package ru.bryzgalin.examPrep.first.trafficLightTask;

class GreenToYellow implements TrafficLightState {
    private static final GreenToYellow INSTANCE = new GreenToYellow();

    private GreenToYellow() {}

    public static GreenToYellow getInstance() {
        return INSTANCE;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Зеленый");
        trafficLight.setState(YellowToRed.getInstance());
    }
}