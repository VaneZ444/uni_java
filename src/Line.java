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
    public String lineInfo(){
        return "Line from " + a.cords() + " to " + b.cords();
    }
}
