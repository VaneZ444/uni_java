package mathematical;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        if(o1.x == o2.x) return o1.y - o2.y;
        return o1.x - o2.x;
    }
}
