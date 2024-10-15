import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<Road> roadList = new ArrayList<>();

    public Map(City... city) {
        appendCityRoads(city);
    }
    public Map(Road... road) {
        addRoad(road);
    }

    public void addRoad(Road... road) {
        for (Road r : road) {
            if (isRoadValid(r)) {
                roadList.add(r);
                r.getRoadFrom().appendRoad(r);
            } else {
                throw new IllegalArgumentException("an exact copy of road " + road + " already exists");
            }
        }
    }
    public void addRoad(City start, City end, int cost) {
        addRoad(new Road(start, end, cost));
    }

    public void appendCityRoads(City... city) {
        for (City c : city) {
            addRoad(c.getRoadList().toArray(new Road[0]));
        }
    }
    public void removeRoad(Road... roadToDel){
        for(Road rd: roadToDel){
            for(Road r: this.roadList){
                if(r.isEqualRoad(rd)){
                    this.roadList.remove(r);
                } else {
                    throw new IllegalArgumentException("all roads chosen for deletion should exist");
                }
            }
        }
    }

    private boolean isRoadValid(Road road) {
        for (Road r : roadList) {
            if (road.isEqualRoad(r)) {
                return false;
            }
        }
        return true;
    }
}

