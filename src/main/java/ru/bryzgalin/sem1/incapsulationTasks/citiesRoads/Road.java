package ru.bryzgalin.sem1.incapsulationTasks.citiesRoads;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
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
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return length == road.length && city == road.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.getCityName(), length);
    }

    @Override
    public String toString() {
        return "Road{" +
                "city=" + city.getCityName() +
                ", length=" + length +
                '}';
    }
}
