import java.util.ArrayList;
import java.util.List;

public class JaggedLine {
    List<Point> linePoints = new ArrayList<>();
    public JaggedLine(Point... points){
        linePoints.addAll(List.of(points));
    }
    public void addPoints(Point... points){
        linePoints.addAll(List.of(points));
    }
    public void addPoints(List<Point> points){
        linePoints.addAll(points);
    }
    public double len(){
        Line temp;
        double length = 0.0;
        for (int i = 0; i < linePoints.size()-1; i++) {
            temp = new Line(linePoints.get(i), linePoints.get(i+1));
            length += temp.lineLen();
        }
        return length;
    }
    @Override
    public String toString() {
        return "JaggedLine{" +
                "linePoints=" + linePoints +
                '}';
    }
}
