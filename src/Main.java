public class Main {
    public static void main(String[] args) {
        oneOneFour();
    }
    public static void oneOneOne(){
        Point[] points;
        points = new Point[3];
        points[0] = new Point();
        points[1] = new Point();
        points[2] = new Point();
        points[0].x = 2;
        points[0].y = 5;
        points[1].x = 23;
        points[1].y = 54;
        points[2].x = 27;
        points[2].y = 57;
        for (Point point : points) {
            System.out.println(point.cords());
        }

    }
    public static void oneOneTwo(){
        Human[] people;
        people = new Human[3];
        people[0] = new Human();
        people[1] = new Human();
        people[2] = new Human();
        people[0].name = "Cleopatra";
        people[0].height = 152;
        people[1].name = "Pushkin";
        people[1].height = 167;
        people[2].name = "Volodymir";
        people[2].height = 189;
        for (Human human : people) {
            System.out.println(human.introduce());
        }
    }
    public static void oneOneThree(){
        Name[] journal;
        journal = new Name[3];
        journal[0] = new Name();
        journal[1] = new Name();
        journal[2] = new Name();
        journal[0].firstName = "Cleopatra";
        journal[1].firstName = "Pushkin";
        journal[1].secondName = "Aleksandr";
        journal[1].thirdName = "Sergeevych";
        journal[2].firstName = "Volodymir";
        journal[2].secondName = "Mayakovskyy";
        for (Name name : journal) {
            System.out.println(name.sayFullName());
        }
    }
    public static void oneOneFour(){
        Time[] timeTests;
        timeTests = new Time[3];
        timeTests[0] = new Time();
        timeTests[1] = new Time();
        timeTests[2] = new Time();
        timeTests[0].time = 10;
        timeTests[1].time = 10000;
        timeTests[2].time = 100000;
        for (Time time : timeTests) {
            System.out.println(time.tellTime());
        }
    }
}