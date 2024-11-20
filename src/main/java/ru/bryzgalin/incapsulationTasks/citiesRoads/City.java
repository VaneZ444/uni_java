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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        if (roadList.size() != city.roadList.size()) return false;
        if (!roadList.containsAll((city.getRoadList()))) return false;
        return Objects.equals(getCityName(),city.getCityName());
        /*
        List<Road> tmp = getRoadList();
        List<Road> tmp2 = city.getRoadList();
        return tmp.containsAll((tmp2));
        */
    }

    @Override
    public final int hashCode() {
        int hashcode = getCityName().hashCode()*31;
        for (Road r: roadList){
            hashcode += r.hashCode();
        }
        return hashcode;
    }
    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", roadList=" + roadList +
                ", alg=" + alg +
                '}';
    }

}
