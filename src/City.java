import java.util.List;
import java.util.ArrayList;

public class City {
    String cityName;
    List<Road> roadList = new ArrayList<>();
    public City(String cityName, Road... roads){
        this.cityName = cityName;
        roadList.addAll(List.of(roads));
    }
    public City(String cityName){
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", roadList=" + roadList +
                '}';
    }
}
