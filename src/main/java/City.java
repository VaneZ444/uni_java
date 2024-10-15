import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.ArrayList;

@Getter
@ToString
public class City {
    private final String cityName;
    private final List<Road> roadList = new ArrayList<>();

    public City(String cityName, Road... roads) {
        this.cityName = cityName;
        appendRoad(roads);
    }

    public void appendRoad(Road... roads) {
        for (Road r : roads) {
            if (isRoadValid(r)) {
                this.roadList.add(r);
            } else {
                throw new IllegalArgumentException("invalid road");
            }
        }
    }
    public void deleteRoad(Road... roadToDel){
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
    public void deleteRoad(City roadFrom, City roadTo){
        deleteRoad(new Road(roadFrom,roadTo,1));
    }
    private boolean isRoadValid(Road road) {
        if (road.getRoadFrom() != this)
            throw new IllegalArgumentException("doesnt eq:" + road.getRoadFrom() + " " + this);
            //return false;
        for (Road r : roadList) {
            if (road.isEqualRoad(r)) {
                return false;
            }
            ;
        }
        return true;
    }
}
