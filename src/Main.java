public class Main {
    public static void main(String[] args) {
        oneTwoFour();
    }
    public static void oneTwoOne() {
        //1
        Line firstLine = new Line();
        firstLine.a.x = 1;
        firstLine.a.y = 3;
        firstLine.b.x = 23;
        firstLine.b.y = 8;
        System.out.println("1 " + firstLine.lineInfo());
        System.out.println(" ");
        //2
        Line secondLine = new Line();
        secondLine.a.x = 5;
        secondLine.a.y = 10;
        secondLine.b.x = 25;
        secondLine.b.y = secondLine.a.y;
        System.out.println("2 " + secondLine.lineInfo());
        System.out.println(" ");
        //3
        Line thirdLine = new Line();
        thirdLine.a = firstLine.a;
        thirdLine.b = secondLine.b;
        System.out.println("3 " + thirdLine.lineInfo());
        System.out.println(" ");
        //4
        firstLine.a.x = 2;
        firstLine.a.y = 6;
        firstLine.b.x = 46;
        firstLine.b.y = 16;
        secondLine.a.x = 10;
        secondLine.a.y = 20;
        secondLine.b.x = 50;
        secondLine.b.y = secondLine.a.y;
        System.out.println("1 " + firstLine.lineInfo());
        System.out.println("2 " + secondLine.lineInfo());
        System.out.println("3 " + thirdLine.lineInfo());
        System.out.println(" ");
        //5
        firstLine.a = new Point();
        firstLine.a.x = 42;
        firstLine.a.y = 33;
        System.out.println("1 " + firstLine.lineInfo());
        System.out.println("3 " + thirdLine.lineInfo());
    }
    public static void oneTwoTwo() {
        Human a = new Human(new Name("Cleopatra", null,null),152, null);
        Human b = new Human(new Name("Aleksandr","Pushkin","Sergeevych"),167, null);
        Human c = new Human(new Name("Aleksandr","Mayakovskiy", null),189, null);

        System.out.println(a.introduce());
        System.out.println(b.introduce());
        System.out.println(c.introduce());
    }
    public static void oneTwoThree(){
        Human a = new Human(new Name("Ivan", "Chudov", null), 170, null);
        Human b = new Human(new Name("Pyotr", "Chudov", null), 172, null);
        Human c = new Human(new Name("Boris", null, null), 174, null);
        System.out.println(a.introduce());
        System.out.println(b.introduce());
        System.out.println(c.introduce());
        System.out.println(" ");
        b.father = a;
        c.father = b;
        System.out.println(a.introduce());
        System.out.println(b.introduce());
        System.out.println(c.introduce());
    }
    public static void oneTwoFour(){
        Department IT = new Department("Information Technologies", null);
        Employee a = new Employee("Petrov", IT);
        Employee b = new Employee("Kozlov", IT);
        Employee c = new Employee("Sidorov", IT);
        IT.departmentBoss = b;
        System.out.println(a.introduce());
        System.out.println(b.introduce());
        System.out.println(c.introduce());
    }
}