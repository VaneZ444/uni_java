public class Point {
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public String cords(){
        return "{" + x + ";" + y + "}";
    }
}
