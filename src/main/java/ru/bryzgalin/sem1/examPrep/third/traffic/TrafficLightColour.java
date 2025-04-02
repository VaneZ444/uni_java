package ru.bryzgalin.sem1.examPrep.third.traffic;

import ru.bryzgalin.sem1.examPrep.third.traffic.TLColour;

public class TrafficLightColour implements TLColour {
    private String colour;
    private TLColour nextColour;

    public TrafficLightColour() {}

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setNextColour(TLColour nextColour) {
        this.nextColour = nextColour;
    }

    @Override
    public TLColour next() {
        return nextColour;
    }

    @Override
    public String get() {
        return colour;
    }
}