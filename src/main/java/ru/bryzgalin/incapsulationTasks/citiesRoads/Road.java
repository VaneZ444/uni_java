package ru.bryzgalin.incapsulationTasks.citiesRoads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
    public Road(City city){
        this(city, 1);
    }
    private boolean lengthIsValid(int length){
        return length>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Objects.equals(city, road.city);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(city);
    }
}
