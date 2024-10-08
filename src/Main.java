public class Main {
    public static void main(String[] args) {
        oneFiveEight();
    }
    public static void oneFourOne(){
        Point a = new Point(3,5);
        Point b = new Point(25,6);
        Point c = new Point(7,8);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static void oneFourTwo(){
        Line a = new Line(new Point(3,5),new Point(25,6));
        Line b = new Line(25,6,7,8);
        Line c = new Line(a.a,b.b);
    }
    public static void oneFourThree(){
        House hotel = new House(4);
    }
    public static void oneFourFour(){
        Time bigNumber = new Time(10000);
        Time threeNumbers = new Time(2,3,5);
        System.out.println(bigNumber);
        System.out.println(threeNumbers);
    }
    public static void oneFourFive(){
        Name a = new Name("Cleo");
        Name b = new Name("Alex", "Serg", "Push");
        Name c = new Name("Volodymir", "Mayak");
        Name d = new Name("Chryst", "Bonyfant");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
    public static void oneFourSix(){
        Human a = new Human("Lev", 170);
        Human b = new Human(new Name("Push", "Serg"),168,a);
        Human c = new Human("Alex",167,b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static void oneFourSeven(){
        Student a = new Student("Vasya", 3,4,5);
        Student b = new Student("Maksim");
        System.out.println(a);
        System.out.println(b);
    }

    public static void oneFiveOne(){
        Pistol sigP226 = new Pistol(3);
        for (int i = 0; i < 5; i++) {
            System.out.println(sigP226.shootString());
        }
    }
    public static void oneFiveTwo(){
        Cat a = new Cat("Barsik");
        System.out.println(a.meow());
        System.out.println(a.meow(3));
    }
    public static void oneFiveThree(){
        Line a = new Line(1,1,10,15);
        System.out.println(a.lineLen());
    }
    public static void oneFiveFour(){
        Time a = new Time(2,3,5);
        System.out.println(a);
    }
    public static void oneFiveFive(){
        Fraction f1 = new Fraction(66,99);
        Fraction f2 = new Fraction(111,333);
        System.out.println(f1 + ", " + f2 + "\n");
        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.sub(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.mul(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
        System.out.println(f1.sum(f2).div(f2).sub(5));
    }
    public static void oneFiveSix(){
        Student a = new Student("Vasya", 3,4,5,4);
        Student b = new Student("Petya", 5,5,5,5);
        System.out.println(a.round());
        System.out.println(a.isIdeal());
        System.out.println(b.round());
        System.out.println(b.isIdeal());
    }
    public static void oneFiveSeven(){
        JaggedLine a = new JaggedLine(new Point(1,5),new Point(2,8),new Point(5,3));
        System.out.println(a.len());
        a.addPoints(new Point(5,15),new Point(8,10));
        System.out.println(a.len());
    }
    public static void oneFiveEight(){
        Square a = new Square(5,3,23);
        JaggedLine b = a.toJagged();
        System.out.println(b.len());
        b.linePoints.set(3, new Point(15,25));
        System.out.println(b.len());
    }
}