package ru.bryzgalin.misc;

import ru.bryzgalin.animals.Bird;
import ru.bryzgalin.exceptions.IllegalMarkException;
import ru.bryzgalin.mathematical.*;
import ru.bryzgalin.interfaces.*;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MethodPack {

    public static double powXY(String x, String y) {
        return pow(parseInt(x), parseInt(y));
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

    public static Storage<Integer> sum(List<Integer> lst) {
        if(lst.isEmpty()) return Storage.empty();
        int sum = 0;
        for (Integer integer : lst) {
            sum += integer;
        }
        return Storage.of(sum);
    }

}
