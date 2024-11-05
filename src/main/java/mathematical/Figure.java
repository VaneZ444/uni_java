package mathematical;

public abstract class Figure {
    protected final Point a;

    public Figure(Point a) {
        this.a = a;
    }

    public Point getA() {
        return new Point(a);
    }

    public abstract double square();
}
