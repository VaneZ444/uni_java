package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.PolyChainable;

public class PolygonalRing extends PolygonalChain implements PolyChainable {
    public PolygonalRing(Point... points) {
        super(points);
    }
    public float len(){
        if (linePoints.size() < 3) return super.len();
        Line tempLine = new Line(linePoints.getFirst(),linePoints.getLast());
        return super.len() + tempLine.len();
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return super.clone();
    }
}
