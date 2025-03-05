package ru.bryzgalin.sem1.mathematical;

import lombok.Getter;
import lombok.Setter;
import ru.bryzgalin.sem1.interfaces.PointMeasurable;
import java.util.Objects;
@Setter
@Getter
public class Point implements Comparable<Point>, Cloneable, PointMeasurable {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point cloned) {
        this(cloned.x, cloned.y);
    }

    public Point move(int dx, int dy){
        x+=dx;
        y+=dy;
        return this;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public int compareTo(Point point) {
        if (this.x == point.x) return (this.y - point.y);
        return (this.x - point.x);
    }
    public Point clone(){
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public float distanceTo(Point p){
        return (float) Math.sqrt((x) * (p.x) + (y) * (p.y));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
