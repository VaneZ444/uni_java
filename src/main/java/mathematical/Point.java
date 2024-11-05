package mathematical;

public class Point {
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Point(Point cloned){
        this(cloned.x,cloned.y);
    }
    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }
}
