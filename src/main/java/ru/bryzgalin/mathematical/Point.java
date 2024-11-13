package ru.bryzgalin.mathematical;

import lombok.EqualsAndHashCode;

import java.util.Objects;

public class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point cloned) {
        this(cloned.x, cloned.y);
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
