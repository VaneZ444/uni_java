public class Main {
    public static void main(String[] args) {
        oneSixTwo();
    }
    public static void oneSixOne(){
        House a = new House(-4);
    }
    public static void oneSixTwo(){
        Time a = new Time(25,25,25);
        Time b = new Time(252525);
        System.out.println(a);
        System.out.println(b);
    }
    public static void oneSixThree(){
        Square a = new Square(3,5,5);
        a.setSide(10);
        System.out.println(a.getSide());
    }
    public static void oneSixFour(){
        Fraction a = new Fraction(3,2);
    }
}