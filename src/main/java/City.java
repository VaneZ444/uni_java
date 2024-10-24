import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.ArrayList;

@Getter
@ToString
public class City {
    protected final String cityName;
    protected final List<Road> roadList = new ArrayList<>();

    public City(String cityName, Road... roads) {
        this.cityName = cityName;
        for(Road r: roads){
            putRoad(r);
        }
    }

    public void putRoad(Road road) {
        for (Road rl : roadList) {
            if (road.getCity() == rl.getCity()) {
                rl.setLength(road.getLength());
            } else {
                this.roadList.add(road);
            }
        }
    }

    public void deleteRoad(Road roadToDel) {
            roadList.removeIf(rl -> roadToDel.getCity() == rl.getCity());
    }

    public void deleteRoad(City roadFrom) {
        deleteRoad(new Road(roadFrom, 1));
    }
}
