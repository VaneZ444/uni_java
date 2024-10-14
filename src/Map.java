import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Road> roadList = new ArrayList<>();

    public void addRoad(City start, City end, int cost) {
        addRoad(new Road(start, end, cost));
    }

    public void addRoad(Road... road) {
        for (Road r : road) {
            if (isRoadValid(r)) {
                roadList.add(r);
            }
        }
        ;
    }

    private boolean isRoadValid(Road road) {
        for (Road r : roadList) {
            if (road.isEqualRoad(r)) {
                return false;
            }
            ;
        }
        return true;
    }
}

