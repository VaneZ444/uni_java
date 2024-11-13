package ru.bryzgalin.mathematical;

import lombok.Getter;
import lombok.Setter;

public class Circle extends Figure{
    @Getter
    @Setter
    private int radius;
    public Circle(Point a, int radius) {
        super(a);
        if (radius < 0) throw new IllegalArgumentException("radius cannot be negative");
        this.radius = radius;
    }
    public Circle(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    @Override
    public double square() {
        return radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "mathematical.Circle{" +
                "radius=" + radius + ", point= " + a +
                '}';
    }
}
