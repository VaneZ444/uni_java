package ru.bryzgalin.sem1.examPrep.templateExamples.structural;

import java.util.ArrayList;
import java.util.List;

/*
Composite (Компоновщик)
Группирует несколько объектов в древовидную структуру используя один класс.
 Позволяет работать с несколькими классами через один объект.
 */
interface Car {
    void paint(String color);
}
class SportCar implements Car {
    public void paint(String color) {
        System.out.println("SportCar color: " + color);
    }
}
class UnknownCar implements Car {
    public void paint(String color) {
        System.out.println("UnknownCar color: " + color);
    }
}
class Drawing implements Car {
    private List<Car> cars = new ArrayList<Car>();
    public void paint(String color) {
        for(Car car : cars) {
            car.paint(color);
        }
    }
    public void add(Car s){
        this.cars.add(s);
    }
    public void clear(){
        System.out.println();
        this.cars.clear();
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car unknownCar = new UnknownCar();
        Drawing drawing = new Drawing();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.paint("green");
        drawing.clear();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.paint("white");
    }
}