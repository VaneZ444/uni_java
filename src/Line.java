public class Line {
    Point a;
    Point b;
    public Line(Point a, Point b){
        this.a = a;
        this.b = b;
    }
    public Line(int aX, int aY, int bX, int bY){
        this(new Point(aX,aY),new Point(bX,bY));
    }
    public double lineLen(){
        return Math.sqrt((a.x)*(b.x)+(a.y)*(b.y));
    }
    @Override
    public String toString(){
        return "Line from " + a + " to " + b;
    }
}
