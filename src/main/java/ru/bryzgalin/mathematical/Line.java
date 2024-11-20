package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.Lenghtable;
import ru.bryzgalin.interfaces.PolyChainable;

import java.util.List;
import java.util.Objects;

public class Line implements Lenghtable, PolyChainable, Cloneable {
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
    public PolyLine getPolygonalChain() {
        return new PolyLine(List.of(new Point(a), new Point(b)));
    }

    @Override
    public String toString() {
        return "mathematical.Line from " + getA() + " to " + getB();
    }
    public Line clone(){
        try {
            Line l = (Line)super.clone();
            l.a = a.clone();
            l.b = b.clone();
            return l;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line)) return false;

        return  (Objects.equals(a, line.a)&&Objects.equals(b, line.b))||
                (Objects.equals(b, line.a)&&Objects.equals(a, line.b));
    }

    @Override
    public int hashCode() {
        return Objects.hash(a)+Objects.hash(b);
    }
}
