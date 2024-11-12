package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.Lenghtable;
import ru.bryzgalin.interfaces.PolyChainable;

import java.util.List;

public class Line implements Lenghtable, PolyChainable {
    private Point a;
    private Point b;

    public Line(Point a, Point b) {
        this.a = new Point(a);
        this.b = new Point(b);
    }

    public Line(int aX, int aY, int bX, int bY) {
        this(new Point(aX, aY), new Point(bX, bY));
    }

    public void setA(Point a) {
        this.a = new Point(a);
    }

    public Point getA() {
        return a;
    }

    public void setB(Point b) {
        this.b = new Point(b);
    }

    public Point getB() {
        return b;
    }

    public float len() {
        return (float) Math.sqrt((getA().x) * (getB().x) + (getA().y) * (getB().y));
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return new PolygonalChain(List.of(new Point(a), new Point(b)));
    }

    @Override
    public String toString() {
        return "mathematical.Line from " + getA() + " to " + getB();
    }
}
