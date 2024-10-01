public class Main {
    public static void main(String[] args) {
        oneThreeTwo();
    }
    public static void oneThreeOne() {
        Student Vasya = new Student("Vasiliy", new int[]{3, 4, 5});
        System.out.println(Vasya.report());
        Student Petya = new Student("Pyotr", Vasya.marks);
        System.out.println(Petya.report());
        Petya.marks[0] = 5;
        System.out.println(Vasya.report());
        System.out.println(Petya.report());
        //оценка василия изменилась потому, что ссылки на оценки василия и петра ведут на один массив;
        System.out.println(Petya.marks);
        System.out.println(Vasya.marks);
        //чтобы этого избежать нужно создать новый массив.
        int[] b = new int[Vasya.marks.length];
        System.arraycopy(Vasya.marks,0,b,0,Vasya.marks.length);
        Student Andrew = new Student("Andrey", b);
        Andrew.marks[0] = 10;
        System.out.println(Vasya.report());
        System.out.println(Andrew.report());
    }
    public static void oneThreeTwo() {
        JaggedLine lineOne = new JaggedLine(new Point[]{new Point(1,5), new Point(2,8),new Point(5,3)});
        System.out.println(lineOne.lineReport());
        //2
        JaggedLine lineTwo = new JaggedLine(new Point[]{
                lineOne.linePoints[0],
                new Point(2,-5),
                new Point(4,-8),
                lineOne.linePoints[lineOne.linePoints.length-1]});
        System.out.println(lineTwo.lineReport());
        lineOne.linePoints[0].x = -10;
        System.out.println(lineTwo.lineReport());
        System.out.println(lineOne.lineReport());
    }
}