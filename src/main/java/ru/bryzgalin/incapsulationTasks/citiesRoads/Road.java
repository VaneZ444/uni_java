package ru.bryzgalin.incapsulationTasks.citiesRoads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Road {
    private City city;
    private int length;
    public Road(City city, int length){
        this.city = city;
        if(!lengthIsValid(length)) throw new IllegalArgumentException("Invalid road length");
        this.length = length;
    }
    private boolean lengthIsValid(int length){
        return length>0;
    }
}
