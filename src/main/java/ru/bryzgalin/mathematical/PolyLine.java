package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.Lenghtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PolyLine implements Lenghtable{
    protected List<Point> linePoints = new ArrayList<>();

    public PolyLine(Point... points) {
        addPoints(points);
    }

    public PolyLine(List<Point> points) {
        addPoints(points);
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

    public PolyLine clone() {
        List<Point> ptList = new ArrayList<>();
        for (Point point : linePoints) {
            ptList.add(new Point(point));
        }
        return new PolyLine(ptList);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolyLine polyLine)) return false;

        List<Point> thisPoints = new ArrayList<>(this.getPoints());
        List<Point> otherPoints = new ArrayList<>(polyLine.getPoints());

        List<Point> tmp = thisPoints.subList(0, thisPoints.size()-1);

        if (tmp.equals(otherPoints.reversed())||thisPoints.equals(otherPoints.reversed())) Collections.reverse(otherPoints);

        if (this instanceof PolyChain) thisPoints.add(thisPoints.getFirst());
        if (o instanceof PolyChain) otherPoints.add(otherPoints.getFirst());

        return thisPoints.equals(otherPoints);
    }

    @Override
    public int hashCode() {
        List<Point> thisPoints = new ArrayList<>(this.getPoints());
        if (this instanceof PolyChain) thisPoints.add(thisPoints.getFirst());
        int hash = 0;
        for(Point p: thisPoints){
            hash+=Objects.hash(p);
        }
        return hash;
    }
}