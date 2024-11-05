package mathematical;

public class Line {
    private Point a;
    private Point b;

    public Line(Point a, Point b){
        this.a = new Point(a);
        this.b = new Point(b);
    }

    public Line(int aX, int aY, int bX, int bY){
        this(new Point(aX,aY),new Point(bX,bY));
    }

    public void setA(Point a) {
        this.a = new Point(a);
    }

    public Point getA() {
        return a;
    }

    public void setB(Point b) {
        this.b = new Point(b);
    }

    public Point getB() {
        return b;
    }

    public double len(){
        return Math.sqrt((getA().x)*(getB().x)+(getA().y)*(getB().y));
    }
    @Override
    public String toString(){
        return "mathematical.Line from " + getA() + " to " + getB();
    }
}
