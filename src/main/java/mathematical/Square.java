package mathematical;

public class Square extends Figure {
    private int squareLength;

    public Square(Point corner, int squareLength) {
        super(corner);
        this.squareLength = squareLength;
    }

    public Square(int x, int y, int squareLength) {
        this(new Point(x, y), squareLength);
    }

    public void setSide(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("mathematical.Square side length must be more that 0");
        } else {
            this.squareLength = side;
        }
    }

    public double square() {
        return squareLength * squareLength;
    }

    public int getSide() {
        return this.squareLength;
    }

    public JaggedLine toJagged() {
        return new JaggedLine(new Point(super.a),
                new Point(super.a.x + getSide(), super.a.y),
                new Point(super.a.x + getSide(), super.a.y + getSide()),
                new Point(super.a.x, super.a.y + getSide()),
                new Point(super.a)
        );
    }

    @Override
    public String toString() {
        return "mathematical.Square in point " + a +
                "with side " + getSide();
    }

}