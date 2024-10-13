public class Main {
    public static void main(String[] args) {
        oneSixEight();
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
    public static void oneSixFive(){
        Pistol m1911 = new Pistol(7,3);
        System.out.println(m1911.shoot(5));
        System.out.println(m1911.reload(8));
        System.out.println(m1911.shoot(2));
        System.out.println(m1911.unload());
        System.out.println(m1911.shoot());
    }
    public static void oneSixSix(){
        Point a = new Point(1,1);
        Point b = new Point(8,8);
        Line c = new Line(a,b);
        Line d = new Line(a,b);
        System.out.println(c.getA().hashCode());
        System.out.println(d.getA().hashCode());
    }
    public static void oneSixEight(){
        Human a = new Human("iven", 500,null);
        System.out.println(a.getName());
    }
}