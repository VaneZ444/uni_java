package ru.bryzgalin.main;

import ru.bryzgalin.misc.dataStream.DataStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = DataStream.of(numbers)
                .map(n -> n * 2)
                .filter(n -> n > 5)
                .reduce(0, Integer::sum);
        System.out.println("sum: " + sum);
    }
}