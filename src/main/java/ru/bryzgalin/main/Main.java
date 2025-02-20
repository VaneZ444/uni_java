package ru.bryzgalin.main;

import ru.bryzgalin.mathematical.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.bryzgalin.mathematical.PolyLine;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("uee\n");
        File f = new File("points.txt");
        Scanner scanner = new Scanner(f);

        List<PolyLine> polyLines = Stream.generate(() -> scanner.nextLine())
                .takeWhile(_ -> scanner.hasNext())
                .map(str -> str.split(" "))
                .map(str -> new Point(
                        Integer.parseInt(str[0]),
                        Integer.parseInt(str[1]))
                )
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .collect(Collectors.groupingBy(Point::getY))//сборка по равной высоте
                .values() //коллекция списков точек
                .stream() //обратно в поток
                .map(PolyLine::new) //каждый список в PolyLine
                .toList();

        polyLines.forEach(System.out::println);

        /*
        List<PolyLine> polyLines2 = Files.lines(f.toPath())
                .map(str -> str.split(" "))
                .map(arr -> new Point(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])))
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .collect()
        */
    }
}