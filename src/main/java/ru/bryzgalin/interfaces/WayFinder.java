package ru.bryzgalin.interfaces;

import ru.bryzgalin.incapsulationTasks.citiesRoads.City;

import java.util.List;
public interface WayFinder {
    public List<City> findWay(City city1, City city2);
}