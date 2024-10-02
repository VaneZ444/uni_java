public class Main {
    public static void main(String[] args) {
        oneThreeFour();
    }
    public static void oneThreeOne() {
        Student Vasya = new Student("Vasiliy", new int[]{3, 4, 5});
        System.out.println(Vasya);
        Student Petya = new Student("Pyotr", Vasya.marks);
        System.out.println(Petya);
        Petya.marks[0] = 5;
        System.out.println(Vasya);
        System.out.println(Petya);
        //оценка василия изменилась потому, что ссылки на оценки василия и петра ведут на один массив;
        System.out.println(Petya.marks);
        System.out.println(Vasya.marks);
        //чтобы этого избежать нужно создать новый массив.
        int[] b = new int[Vasya.marks.length];
        System.arraycopy(Vasya.marks,0,b,0,Vasya.marks.length);
        Student Andrew = new Student("Andrey", b);
        Andrew.marks[0] = 10;
        System.out.println(Vasya);
        System.out.println(Andrew);
    }
    public static void oneThreeTwo() {
        JaggedLine lineOne = new JaggedLine(new Point[]{new Point(1,5), new Point(2,8),new Point(5,3)});
        System.out.println(lineOne);
        //2
        JaggedLine lineTwo = new JaggedLine(new Point[]{
                lineOne.linePoints[0],
                new Point(2,-5),
                new Point(4,-8),
                lineOne.linePoints[lineOne.linePoints.length-1]});
        System.out.println(lineTwo);
        lineOne.linePoints[0].x = -10;
        System.out.println(lineTwo);
        System.out.println(lineOne);
    }
    public static void oneThreeThree() {
        City[] web = new City[6];
        char temp;
        for (int i = 0; i < web.length; i++) {
            temp = (char)('A' + i);
            web[i] = new City(Character.toString(temp));
            System.out.println(web[i].cityName);
        }
        web[0] = new City("A", new City[]{web[1],web[3],web[5]}, new int[]{5,6,1});
        web[1] = new City("B", new City[]{web[0],web[2]}, new int[]{5,3});
        web[2] = new City("C", new City[]{web[3],web[1]}, new int[]{4,3});
        web[3] = new City("D", new City[]{web[0],web[4],web[2]}, new int[]{6,2,4});
        web[4] = new City("E", new City[]{web[5]}, new int[]{2});
        web[5] = new City("F", new City[]{web[1],web[4]}, new int[]{1,2});
        for (int i = 0; i < web.length; i++) {
            System.out.println(web[i]);
        }
        /*City a, b, c, d, e, f;

        a = new City("A");
        b = new City("B");
        c = new City("C");
        d = new City("D");
        e = new City("E");
        f = new City("F");

        a = new City("A", new City[]{b,d,f}, new int[]{5,6,1});
        b = new City("B", new City[]{a,c}, new int[]{5,3});
        c = new City("C", new City[]{d,b}, new int[]{4,3});
        d = new City("D", new City[]{a,e,c}, new int[]{6,2,4});
        e = new City("E", new City[]{f}, new int[]{2});
        f = new City("F", new City[]{b,e}, new int[]{1,2});
        */

    }
    public static void oneThreeFour() {
        Department IT = new Department("Intellectual Technologies", 50);
        IT.addEmployee(new Employee("Oleg", IT));
        IT.addEmployee(new Employee("Pyotr", IT));
        IT.addEmployee(new Employee("Cleopatra", IT));
        IT.addEmployee(new Employee("Iosif", IT));

        IT.addBoss(IT.getEmployeeByName("Iosif"));

        IT.tellCurrStaff();
        //еще можно вот так
        Employee a = new Employee("Aleksey", IT);
        IT.addEmployee(a);

        System.out.println(IT.getEmployeeByName("Iosif").assignedDepartment.tellCurrStaff());
        System.out.println(IT.departmentBoss.employeeName);
    }
}
