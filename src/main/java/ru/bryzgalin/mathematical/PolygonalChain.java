package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.Lenghtable;

import java.util.ArrayList;
import java.util.List;

public class PolygonalChain implements Lenghtable {
    protected List<Point> linePoints = new ArrayList<>();

    public PolygonalChain(Point... points) {
        linePoints.addAll(List.of(points));
    }

    public PolygonalChain(List<Point> points) {
        linePoints.addAll(points);
    }

    public void addPoints(Point... points) {
        linePoints.addAll(List.of(points));
    }

    public void addPoints(List<Point> points) {
        linePoints.addAll(points);
    }

    public float len() {
        Line temp;
        float length = 0;
        for (int i = 0; i < linePoints.size() - 1; i++) {
            temp = new Line(linePoints.get(i), linePoints.get(i + 1));
            length += temp.len();
        }
        return length;
    }

    public PolygonalChain clone() {
        List<Point> ptList = new ArrayList<>();
        for (Point point : linePoints) {
            ptList.add(new Point(point));
        }
        return new PolygonalChain(ptList);
    }

    public List<Point> getPoints() {
        List<Point> ptList = new ArrayList<>();
        for (Point point : linePoints) {
            ptList.add(new Point(point));
        }
        return ptList;
    }

    @Override
    public String toString() {
        return "mathematical.JaggedLine{" +
                "linePoints=" + linePoints +
                '}';
    }
}
