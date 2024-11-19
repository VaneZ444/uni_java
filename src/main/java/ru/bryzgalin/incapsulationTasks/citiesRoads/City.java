package ru.bryzgalin.incapsulationTasks.citiesRoads;

import ru.bryzgalin.interfaces.WayFinder;
import lombok.Getter;
import lombok.ToString;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.mathematical.PolyChain;

import java.util.*;

public class City {
    @Getter
    protected final String cityName;
    protected final List<Road> roadList = new ArrayList<>();
    protected final WayFinder alg;

    public City(String cityName, WayFinder alg, Road... roads) {
        this.cityName = cityName;
        for (Road r : roads) {
            putRoad(r);
        }
        this.alg = alg;
    }

    public List<City> getWayTo(City city) {
        return alg.findWay(this, city);
    }

    public void putRoad(Road road) {
        for (Road nr : roadList) {
            if (road.getCity() == nr.getCity()) {
                nr.setLength(road.getLength());
                return;
            }
        }
        this.roadList.add(road);
    }

    public void deleteRoad(Road roadToDel) {
        roadList.removeIf(rl -> roadToDel.getCity() == rl.getCity());
    }

    public void deleteRoad(City roadFrom) {
        deleteRoad(new Road(roadFrom, 1));
    }

    public List<Road> getRoadList() {
        List<Road> roadCpy = new ArrayList<>();
        for(Road r: roadList){
            roadCpy.add(new Road(r.getCity(), r.getLength()));
        }
        return roadCpy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        List<Road> tmp = getRoadList();
        List<Road> tmp2 = city.getRoadList();
        return tmp.containsAll((tmp2));
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", roadList=" + roadList +
                ", alg=" + alg +
                '}';
    }

    @Override
    public int hashCode() {
        System.out.println("doing hash for " + this.getCityName());
        List<Road> thisRoads = new ArrayList<>(this.getRoadList());
        System.out.println("his cities are:" + thisRoads);
        int hash = 0;
        for(Road r: thisRoads){
            hash+=r.hashCode();
        }
        System.out.println("hash for " + this.getCityName() + " is " + hash);
        return hash;
    }
}
