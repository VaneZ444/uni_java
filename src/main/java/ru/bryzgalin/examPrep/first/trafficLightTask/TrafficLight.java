package ru.bryzgalin.examPrep.first.trafficLightTask;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        this.state = GreenToYellow.getInstance();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}