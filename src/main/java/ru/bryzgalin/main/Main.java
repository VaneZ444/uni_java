package ru.bryzgalin.main;

import ru.bryzgalin.animals.Bird;
import ru.bryzgalin.exceptions.IllegalMarkException;
import ru.bryzgalin.incapsulationTasks.citiesRoads.City;
import ru.bryzgalin.incapsulationTasks.citiesRoads.ComeBackCity;
import ru.bryzgalin.incapsulationTasks.citiesRoads.Road;
import ru.bryzgalin.interfaces.Lenghtable;
import ru.bryzgalin.interfaces.Meowable;
import ru.bryzgalin.interfaces.PolyChainable;
import ru.bryzgalin.mathematical.*;
import ru.bryzgalin.misc.Student;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        cloneTest();
    }
    public static void cloneTest(){
        Fraction a = new Fraction(5,2);
        Fraction b = a.clone();
        System.out.println(a);
        System.out.println(b);
        Point c = new Point(2,4);
        Point d = c.clone();
        System.out.println(c);
        System.out.println(d);

        Line aa = new Line(2,4,3,6);
        System.out.println(aa);
        Line bb = aa.clone();
        System.out.println(bb);

    }
    public static void studentTest(){
        Student oleg = new Student("Oleg", 5,4,3);
        Student olegg = new Student("Oleg", 5,4,3);
        System.out.println(olegg.equals(oleg));

        System.out.println(olegg.hashCode());
        System.out.println(oleg.hashCode());
    }
    public static void cityTest(){
        PolyChain a = new PolyChain(new Point(1,4), new Point(7,3), new Point(4,6));
        PolyLine b = new PolyLine(new Point(1,4),new Point(4,6), new Point(7,3), new Point(1,4));
        City city3 = new City("Narva", null);
        City city4 = new City("London",null);
        ComeBackCity city1 = new ComeBackCity("Ufa", null,new Road(city4));
        City city2 = new City("Tomsk", null,new Road(city3));
        System.out.println(city1.equals(city2));
        System.out.println(city2.equals(city1));
        System.out.println(city2.hashCode());
        //System.out.println(city1.hashCode());
    }
    //--//

    public static double packageSum() {
        return summarize(7, new Fraction(11,3),3.21, new BigInteger("12345678912345678912"));
    }

    public static double powXY(String x, String y){
        return pow(parseInt(x),parseInt(y));
    }

    public static PolyLine chainConnector(PolyChainable... polyChainables) {
        List<Point> bigList = new ArrayList<>();
        for (PolyChainable plc : polyChainables) {
            bigList.addAll(plc.getPolygonalChain().getPoints());
        }
        return new PolyLine(bigList);
    }

    public static float sumMeasurer(List<Lenghtable> lenghtables) {
        float sum = 0;
        for (Lenghtable lenghtable : lenghtables) {
            sum += lenghtable.len();
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

    public static double summarize(Number... numbers) {
        double sum = 0;

        for (Number num : numbers) {
            sum += num.doubleValue();
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