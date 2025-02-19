package ru.bryzgalin.main;

import ru.bryzgalin.mathematical.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.bryzgalin.mathematical.PolyLine;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("uee\n");
        Scanner scanner = new Scanner(new File("points.txt"));

        List<PolyLine> polyLines = Stream.generate(() -> scanner.nextLine())
                .takeWhile(_ -> scanner.hasNext())
                .map(str -> str.split(" "))
                .map(str -> new Point(
                        Integer.parseInt(str[0]),
                        Integer.parseInt(str[1]))
                )
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .collect(Collectors.groupingBy(Point::getY))
                .values() //коллекция списков точек
                .stream() //поток списков точек
                .map(PolyLine::new) //каждый список в PolyLine
                .toList();

        // Выводим результат
        polyLines.forEach(System.out::println);
    }
}