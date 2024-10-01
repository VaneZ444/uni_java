public class Line {
    Point a;
    Point b;
    public Line(Point a, Point b){
        this.a = a;
        this.b = b;
    }
    public String lineInfo(){
        return "Line from " + a.cords() + " to " + b.cords();
    }
}
