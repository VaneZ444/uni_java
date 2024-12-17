package ru.bryzgalin.examPrep.first.trafficLightTask;

class YellowToGreen implements TrafficLightState {
    private static final YellowToGreen INSTANCE = new YellowToGreen();

    private YellowToGreen() {}

    public static YellowToGreen getInstance() {
        return INSTANCE;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Желтый");
        trafficLight.setState(GreenToYellow.getInstance());
    }
}