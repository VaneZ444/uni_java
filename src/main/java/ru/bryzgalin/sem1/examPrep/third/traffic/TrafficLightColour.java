package ru.bryzgalin.sem1.examPrep.third.traffic;

public class TrafficLightColour implements TLColour {
    public String colour;
    public TLColour nextColour;
    public TrafficLightColour(String colour){
        this.colour = colour;
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
