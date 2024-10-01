public class City {
    String cityName;
    City[] roadsTo;
    int[] roadPrices;
    public City(String cityName, City[] roadsTo, int[] roadPrices){
        this.cityName = cityName;
        this.roadsTo = roadsTo;
        this.roadPrices = roadPrices;
    }
    public City(String cityName){
        this(cityName, new City[0], new int[0]);
    }
    public String cityInfo(){
        String infoString = cityName + " roads: ";
        for (int i = 0; i < roadsTo.length; i++)
            infoString = infoString + "[ to " + roadsTo[i].cityName + " : " + roadPrices[i] + " ] ";
        return infoString;
    }
}
