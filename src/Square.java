public class Square {
    Point corner;
    private int squareLength;
    public Square(Point corner, int squareLength){
        this.corner = corner;
        this.squareLength = squareLength;
    }
    public Square(int x, int y, int squareLength){
        this(new Point(x,y),squareLength);
    }
    public void setSide(int side){
        if(side <= 0){
            throw new IllegalArgumentException("Square side length must be more that 0");
        } else {
            this.squareLength = side;
        }
    }
    public int getSide(){
        return this.squareLength;
    }
    public JaggedLine toJagged(){
        return new JaggedLine(new Point(corner),
                new Point(corner.x + getSide(), corner.y),
                new Point(corner.x + getSide(), corner.y + getSide()),
                new Point(corner.x, corner.y + getSide()),
                new Point(corner)
                );
    }
    @Override
    public String toString() {
        return "Square in point " + corner +
                "with side " + getSide();
    }
}
