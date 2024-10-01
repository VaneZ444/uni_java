public class Line {
    Point a = new Point();
    Point b = new Point();
    public String lineInfo(){
        return "Line from " + a.cords() + " to " + b.cords();
    }
}
