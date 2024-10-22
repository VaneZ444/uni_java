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
        putRoad(roads);
    }

    public void putRoad(Road... roads) {
        for (Road r : roads) {
            for(Road rl: roadList) {
                if (r.getCity() == rl.getCity()) {
                    rl.setLength(r.getLength());
                } else {
                    this.roadList.add(r);
                }
            }
        }
    }
    public void deleteRoad(Road... roadsToDel){
        for (Road rd : roadsToDel) {
            roadList.removeIf(rl -> rd.getCity() == rl.getCity());
        }
    }
    public void deleteRoad(City roadFrom){
        deleteRoad(new Road(roadFrom,1));
    }
}
