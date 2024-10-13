public class Road {
    City roadTo;
    int roadCost;
    public Road(City roadTo, int roadCost){
        this.roadTo = roadTo;
        this.roadCost = roadCost;
    }

    @Override
    public String toString() {
        return "Road{" +
                "roadTo=" + roadTo +
                ", roadCost=" + roadCost +
                '}';
    }
}
