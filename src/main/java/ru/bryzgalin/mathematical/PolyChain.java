package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.PolyChainable;

import java.util.ArrayList;
import java.util.List;

public class PolyChain extends PolyLine implements PolyChainable {
    public PolyChain(Point... points) {
        super(points);
    }
    public float len(){
        if (linePoints.size() < 3) return super.len();
        Line tempLine = new Line(linePoints.getFirst(),linePoints.getLast());
        return super.len() + tempLine.len();
    }
    public List<Point> getPoints(){
        return super.getPoints();
    }

    @Override
    public PolyLine getPolygonalChain() {
        return super.clone();
    }
    public PolyLine toPolyLine(){
        List<Point> tmp= new ArrayList<>(getPoints());
        tmp.add(getPoints().getFirst());
        return new PolyLine(tmp);
    }
}
