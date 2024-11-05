import mathematical.Circle;
import mathematical.Square;
import mathematical.Triangle;

public class Main {
    public static void main(String[] args) {
        Square first = new Square(4,5, 10);
        System.out.println(first.square());
        Circle second = new Circle(4,5,3);
        System.out.println(second);
        Triangle third = new Triangle(3,4,6,2,23,5);
        System.out.println(third);
        System.out.println(third.square());
    }
}