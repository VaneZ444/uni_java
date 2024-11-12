package ru.bryzgalin.mathematical;

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
}
