public class ComeBackCity extends City {
    public ComeBackCity(String cityName, Road... roads) {
        super(cityName, roads);
    }
    public void putRoad(Road road){
        super.putRoad(road);
        road.getCity().putRoad(new Road(this, road.getLength()));
    }
}
