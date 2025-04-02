package ru.bryzgalin.sem1.examPrep.third.traffic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    private TLColour currentColour;

    @Autowired
    public TrafficLight(@Qualifier("red") TLColour redColour) {
        this.currentColour = redColour;
    }

    public void next() {
        System.out.println(currentColour.get());
        currentColour = currentColour.next();
    }

    public String getCurrentColor() {
        return currentColour.get();
    }
}