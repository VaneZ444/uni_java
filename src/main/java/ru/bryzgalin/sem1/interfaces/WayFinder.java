package ru.bryzgalin.sem1.interfaces;

import ru.bryzgalin.sem1.incapsulationTasks.citiesRoads.City;

import java.util.List;
public interface WayFinder {
    public List<City> findWay(City city1, City city2);
}
