package ru.bryzgalin.main;

import ru.bryzgalin.interfaces.Filter;
import ru.bryzgalin.interfaces.Function;
import ru.bryzgalin.mathematical.Fraction;
import ru.bryzgalin.mathematical.Line;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.mathematical.VolumetricPoint;
import ru.bryzgalin.misc.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //moveTest();
        //maxStorageTest();
        //storePointTest();
        //fillTest();
        //
        //applierTest();
        //filterTest();
        //reductorTest();

    }
    public static void collectionsTest() {

    }
    public static void reductorTest() {
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> numbers = List.of(1, -3, 7);
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3),
                List.of(-1, -5, -3),
                List.of(4, 4, 4)
        );


        Function<List<String>, String> stringSum = val -> {
            String sum = "";
            for (String str : val) {
                sum += str;
            }
            return sum;
        };

        Function<List<Integer>, Integer> intSum = val -> {
            int s = 0;
            for (int i : val) {
                s += i;
            }
            return s;
        };

        Function<List<List<Integer>>, Integer> listCount = val -> {
            int s = 0;
            for (List<Integer> item : val) {
                s += intSum.apply(item);
            }
            return s;
        };
        System.out.println(reductor(strings, stringSum, ""));
        System.out.println(reductor(numbers, intSum, 0));
        System.out.println(reductor(lists, listCount, List.of()));

        /*
        Function<List<List<Integer>>, List<Integer>> listCount = val -> {
            List<Integer> countsList = new ArrayList<>();
            for (List<Integer> item : val) {
                countsList.add(item.size());
            }
            return countsList;
        };
        System.out.println(reductor(lists, listCount, List.of(0)));
        */
    }

    public static void filterTest() {
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> numbers = List.of(1, -3, 7);
        List<int[]> arrays = List.of(
                new int[]{1, 2, 3},
                new int[]{-1, -5, -3},
                new int[]{4, 4, 4}
        );
        Function<String, Integer> strToLen = String::length;
        Filter<String> lessThanThree = item -> {
            if (item.length() < 3) return true;
            return false;
        };
        Filter<Integer> ifPositive = item -> item > 0;
        Filter<int[]> negativeArr = item -> {
            for (int i : item) {
                if (i > 0) return false;
            }
            return true;
        };
        System.out.println(filter(strings, lessThanThree));
        System.out.println(filter(numbers, ifPositive));
        System.out.println(filter(arrays, negativeArr));
    }

    public static void applierTest() {
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> numbers = List.of(1, -3, 7);
        List<int[]> arrays = List.of(
                new int[]{1, 2, 3},
                new int[]{-1, -5, -3},
                new int[]{4, 4, 4}
        );
        Function<String, Integer> strToLen = String::length;
        System.out.println(transform(strings, strToLen));
        System.out.println(transform(numbers, Math::abs));
        System.out.println(transform(arrays, value -> {
            int max = value[0];
            for (int num : value) {
                if (num > max) max = num;
            }
            return max;
        }));
    }

    public static void fillTest() {
        List<Long> longLst = new ArrayList<>();
        System.out.println(fillList(longLst));
    }

    public static void storePointTest() {
        Storage<VolumetricPoint> str = storePoint(Storage.empty());
        System.out.println(str);
    }

    public static void maxStorageTest() {
        List<Storage<Number>> lst = List.of(
                Storage.of(26),
                Storage.of(new Fraction(300, 4)),
                Storage.of(34.234));

        System.out.println(findMaxStoraged(lst));
    }

    public static void moveTest() {
        Line<VolumetricPoint> a = new Line<>(new VolumetricPoint(2, 5, 6), new VolumetricPoint(-5, 3, 67));
        System.out.println(a);
        System.out.println(moveX10(a));
    }

    ////
    //public static <P, T> Collection<P<T>> collect(List<T>, )
    public static <T> T reductor(List<T> lst, Function reductorRule, T alt){
        if (lst.isEmpty()) return alt;
        return (T)reductorRule.apply(lst);
    }

    public static <T> List<T> filter(List<T> lst, Filter filterRule) {
        if (filterRule == null) return lst;
        List<T> filtered = new ArrayList<>();
        for (T item : lst) {
            if (filterRule.test(item)) filtered.add(item);
        }
        return filtered;
    }

    public static <T, P> List<P> transform(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    ////
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