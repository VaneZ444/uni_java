import java.util.ArrayList;
import java.util.List;

public class JaggedLine {
    List<Point> linePoints = new ArrayList<>();
    public JaggedLine(Point... points){
        linePoints.addAll(List.of(points));
    }
}
