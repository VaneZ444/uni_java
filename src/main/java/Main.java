import funkyDot2.FunkyDot;
import mathematical.Circle;
import mathematical.Square;
import mathematical.Triangle;
import misc.Time;

public class Main {
    public static void main(String[] args) {
        FunkyDot test = new FunkyDot.Builder().addZ(0).addX(0).addY(6).build();
        FunkyDot test2 = new FunkyDot.Builder().addZ(6).addTimestamp(new Time(1337)).addColor("green").build();
        System.out.println(test);
        System.out.println(test2);

    }
}