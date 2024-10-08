public class Square {
    Point corner;
    int squareLength;
    public Square(Point corner, int squareLength){
        this.corner = corner;
        this.squareLength = squareLength;
    }
    public Square(int x, int y, int squareLength){
        this.corner = new Point(x,y);
        this.squareLength = squareLength;
    }
    public JaggedLine toJagged(){
        return new JaggedLine(new Point(corner),
                new Point(corner.x + squareLength, corner.y),
                new Point(corner.x + squareLength, corner.y + squareLength),
                new Point(corner.x, corner.y + squareLength),
                new Point(corner)
                );
    }
    @Override
    public String toString() {
        return "Square in point " + corner +
                "with side " + squareLength;
    }
}
