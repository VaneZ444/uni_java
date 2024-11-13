package ru.bryzgalin.main;

import ru.bryzgalin.animals.Bird;
import ru.bryzgalin.exceptions.IllegalMarkException;
import ru.bryzgalin.interfaces.Lenghtable;
import ru.bryzgalin.interfaces.Meowable;
import ru.bryzgalin.interfaces.PolyChainable;
import ru.bryzgalin.mathematical.Figure;
import ru.bryzgalin.mathematical.Fraction;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.mathematical.PolygonalChain;
import ru.bryzgalin.misc.Student;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        System.out.println(powXY(args[0],args[1]));
        Point ue = new Point(3,5);
        java.awt.Point jue = new java.awt.Point(5,4);
        System.out.println(ue);
        System.out.println(jue);
    }

    //--//

    public static double packageSum() {
        return summarize(7, new Fraction(11,3),3.21, new BigInteger("12345678912345678912"));
    }
    public static double powXY(String x, String y){
        return pow(parseInt(x),parseInt(y));
    }

    //--//

    public static PolygonalChain chainConnector(PolyChainable... polyChainables) {
        List<Point> bigList = new ArrayList<>();
        for (PolyChainable plc : polyChainables) {
            bigList.addAll(plc.getPolygonalChain().getPoints());
        }
        return new PolygonalChain(bigList);
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