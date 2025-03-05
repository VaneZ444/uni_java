package ru.bryzgalin.sem1.examPrep.third.traffic;

public class TrafficLight {
    public TLColour curColour;

    public void next() {
        System.out.println(curColour.get());
        curColour = curColour.next();
    }
}
/*
* TrafficLight tf = new TrafficLight();
        TrafficLightColour red = new TrafficLightColour("red");
        TrafficLightColour yellowToGreen = new TrafficLightColour("yellow");
        TrafficLightColour green = new TrafficLightColour("green");
        TrafficLightColour yellowToRed = new TrafficLightColour("yellow");
        red.nextColour = yellowToGreen;
        yellowToGreen.nextColour = green;
        green.nextColour = yellowToRed;
        yellowToRed.nextColour = red;
        tf.curColour = green;
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        * */