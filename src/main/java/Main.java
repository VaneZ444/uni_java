import animals.*;
import exceptions.IllegalMarkException;
import interfaces.Measurable;
import interfaces.Meowable;
import interfaces.PolyChainable;
import mathematical.*;
import misc.Student;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //birdTest();
        //sumTest();
        //StudentTest();
        //squareTest();
        //meowTest();
        //measureTest();
        //polyRingTest();
        chainablesTest();
    }

    public static void chainablesTest() {
        PolygonalChain megaChain = chainConnector(
                new Line(2,8,5,4),
                new Triangle(5,2,11,16,7,22),
                new Square(2,4,50),
                new PolygonalRing(new Point(14,7), new Point(22,2), new Point(33,11))
        );
        System.out.println(megaChain);
    }
    public static void polyRingTest() {
        Square sqr = new Square(2, 2, 144);
        System.out.println(sqr.toJagged());
    }

    public static void measureTest() {
        System.out.println(sumMeasurer(List.of(new Line(2, 2, 4, 4), new PolygonalChain(new Point(2, 8), new Point(6, 4)))));
    }

    public static void meowTest() {
        massMeow(List.of(new Cat("fluffy"), new Parrot("fake cat")));
    }

    public static void StudentTest() {
        Student std = new Student("vasya");
        Student std2 = new Student("alex", mark -> mark >= 1 && mark <= 2);
        Student std3 = new Student("serg");
        addMark(2, std, std2, std3);
        System.out.println(std);
        System.out.println(std2);
        System.out.println(std3);
        System.out.println("\n");
        addMark(5, std, std3);
        System.out.println(std);
        System.out.println(std2);
        System.out.println(std3);
        System.out.println("\n");
        addMark(5, std, std2, std3);
        System.out.println(std);
        System.out.println(std2);
        System.out.println(std3);
        System.out.println("\n");
    }

    public static void sumTest() {
        System.out.println(summarize(List.of(2, new Fraction(3, 5), 2.3)));
        System.out.println(summarize(List.of(3.6, new Fraction(49, 12), 3, new Fraction(3, 2))));
        System.out.println(summarize(List.of(2, new Fraction(3, 5), 2.3)));
    }

    public static void birdTest() {
        System.out.println(singBirdChorus(List.of(
                new Cuckoo("sergey"),
                new Parrot("alex", "Lorem ipsum"),
                new Sparrow("Temo"),
                new Cuckoo("Kel"))));
    }

    public static void squareTest() {
        System.out.println(calcGeneralSquare(List.of(
                new Triangle(2, 5, 3, 6, 7, 4),
                new Circle(2, 3, 3),
                new Square(2, 2, 4),
                new Rectangle(5, 5, 7, 8))));
    }

    public static PolygonalChain chainConnector(PolyChainable... polyChainables) {
        List<Point> bigList = new ArrayList<>();
        for (PolyChainable plc : polyChainables) {
            bigList.addAll(plc.getPolygonalChain().getPoints());
        }
        return new PolygonalChain(bigList);
    }

    public static float sumMeasurer(List<Measurable> measurables) {
        float sum = 0;
        for (Measurable measurable : measurables) {
            sum += measurable.len();
        }
        return sum;
    }

    public static void massMeow(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }

    public static void addMark(int x, Student... students) {
        List<Student> markedOnes = new ArrayList<>();
        for (Student s : students) {
            try {
                s.addMarks(x);
                markedOnes.add(s);
            } catch (IllegalMarkException e) {
                for (Student t : markedOnes) {
                    t.removeMark(x);
                }
                break;
            }
        }
    }

    public static float summarize(List<?> values) {
        float sum = 0;

        for (Object value : values) {
            if (value instanceof Integer) {
                sum += (Integer) value;
            } else if (value instanceof Float) {
                sum += (Float) value;
            } else if (value instanceof Fraction) {
                sum += ((Fraction) value).floatValue();
            } else if (value instanceof Number) {
                sum += ((Number) value).floatValue();
            } else {
                throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
            }
        }

        return sum;
    }

    public static String singBirdChorus(List<Bird> birds) {
        String str = "what a symphony to behold:\n";
        for (Bird bird : birds) {
            str = str + bird.sing() + "\n";
        }
        return str;
    }

    public static float calcGeneralSquare(List<Figure> figures) {
        float sqr = 0;
        for (Figure figure : figures) {
            sqr += (float) figure.square();
        }
        return sqr;
    }
}