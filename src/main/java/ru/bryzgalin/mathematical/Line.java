package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.Lenghtable;
import ru.bryzgalin.interfaces.PolyChainable;

import java.util.List;
import java.util.Objects;

public class Line<T extends Point> implements Lenghtable, PolyChainable, Cloneable {
    private T a;
    private T b;

    private Line(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public static final Line<Point> of(int aX, int aY, int bX, int bY) {
        return new Line(new Point(aX, aY), new Point(bX, bY));
    }

    public static final <V extends Point> Line<V> of(V p1, V p2){
        return new Line<>(p1,p2);
    }
    public void setA(T a) {
        this.a = (T) a.clone();
    }

    public T getA() {
        return (T) a.clone();
    }

    public void setB(T b) {
        this.b = (T) b.clone();
    }

    public T getB() {
        return (T) b.clone();
    }
    public Line<T> move(int dx, int dy){
        a.move(dx,dy);
        b.move(dx,dy);
        return this;
    }
    public float len() {
        return a.distanceTo(b);
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
