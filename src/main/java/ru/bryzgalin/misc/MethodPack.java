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
        if (lst.isEmpty()) return Storage.empty();
        int sum = 0;
        for (Integer integer : lst) {
            sum += integer;
        }
        return Storage.of(sum);
    }

    public static <T extends Number> List<T> fillList(List<T> list) {
        for (int i = 1; i <= 100; i++) {
            list.add((T) Integer.valueOf(i));
        }
        return list;
    }

    public static <T extends VolumetricPoint> Storage<T> storePoint(Storage<?> storage) {
        storage = Storage.of(new VolumetricPoint(2, 3, 6));
        return (Storage<T>) storage;
    }

    public static <T extends Number> double findMaxStoraged(List<Storage<T>> storageList) {
        double max = 0.0;
        for (Storage<T> storage : storageList) {
            double a = storage.getItem((T) Integer.valueOf(0)).doubleValue();
            if (a > max) max = a;
        }
        return max;
    }

    public static <T extends Point> Line<T> moveX10(Line<T> line) {
        Point a = line.getA();
        Point b = line.getB();
        if (a.getX() < 0) {
            a.setX(a.getX() - 10);
        } else {
            a.setX(a.getX() + 10);
        }
        if (b.getX() < 0) {
            b.setX(b.getX() - 10);
        } else {
            b.setX(b.getX() + 10);
        }
        return line;
    }
}
