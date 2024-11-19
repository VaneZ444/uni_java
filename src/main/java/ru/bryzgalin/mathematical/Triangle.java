package ru.bryzgalin.mathematical;

import ru.bryzgalin.interfaces.PolyChainable;

public class Triangle extends Figure implements PolyChainable {
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        super(a);
        this.b = b;
        this.c = c;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    @Override
    public double square() {
        double sideA = new Line(a, b).len();
        double sideB = new Line(a, c).len();
        double sideC = new Line(b, c).len();
        double p = (sideA + sideB + sideC) / 2;
        double s = Math.sqrt((p * (p - sideA) * (p - sideB) * (p - sideC)));
        return s;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return new PolyLine(new Point(a), new Point(b), new Point(c));
    }

    @Override
    public String toString() {
        return "mathematical.Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
