package ru.bryzgalin.incapsulationTasks.citiesRoads;

import lombok.Getter;
import ru.bryzgalin.interfaces.WayFinder;
@Getter
public class ComeBackCity extends City {
    public ComeBackCity(String cityName, WayFinder alg, Road... roads) {
        super(cityName, alg, roads);
    }
    public void putRoad(Road road){
        super.putRoad(road);
        road.getCity().putRoad(new Road(this, road.getLength()));
    }
}
