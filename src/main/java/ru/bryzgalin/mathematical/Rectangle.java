package ru.bryzgalin.mathematical;

import lombok.Getter;

@Getter
public class Rectangle extends Figure{
    private int len;
    private int len2;
    public Rectangle(Point a,int len, int len2) {
        super(a);
        this.len = len;
        this.len2 = len2;
    }
    public Rectangle(int x, int y, int len, int len2) {
        this(new Point(2,3),3,7);
    }
    public PolyLine toJagged() {
        return new PolyChain(
                new Point(super.a),
                new Point(super.a.x + len, super.a.y),
                new Point(super.a.x + len, super.a.y + len2),
                new Point(super.a.x, super.a.y + len2)
        );
    }

    @Override
    public double square() {
        return len*len2;
    }
}
