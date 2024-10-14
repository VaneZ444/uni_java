public class Road {
    City roadTo;
    City roadFrom;
    int length;
    public Road(City roadFrom,City roadTo, int roadCost){
        this.roadFrom = roadFrom;
        this.roadTo = roadTo;
        this.length = roadCost;
    }
    public boolean isEqualRoad(Road r){
        return (this.roadTo.equals(r.roadTo)&&this.roadFrom.equals(r.roadFrom));
    }
    @Override
    public String toString() {
        return "Road{" +
                "roadTo=" + roadTo +
                ", roadCost=" + length +
                '}';
    }
}
