public class Main {
    public static void main(String[] args) {
        oneFourSeven();
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
}