package ru.bryzgalin.main;

import ru.bryzgalin.animals.Parrot;
import ru.bryzgalin.mathematical.Fraction;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.mathematical.VolumetricPoint;
import ru.bryzgalin.misc.*;
import ru.bryzgalin.weaponry.Pistol;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //boxTest();
        //storageTest(); //?????
        //comparableTest();
        //pointsTest();
        stackTest();
    }

    public static void stackTest() {
        ObjectStack objects = new ObjectStack<>();
        objects.push(new Point(2,3));
        objects.push(new Parrot("kesh","lorem ipsum"));
        objects.push(new Human("oleg",174));
        objects.push(new Pistol(6,3));
        while (!objects.isEmpty()){
            System.out.println(objects.pop());
        }
    }
    public static void pointsTest(){
        VolumetricPoint a = new VolumetricPoint(2, 3, 4);
        VolumetricPoint b = new VolumetricPoint(2, 3, 7);
        System.out.println(a.distanceTo(b));
    }

    public static void comparableTest() {
        Fraction a = new Fraction(2, 6);
        Fraction b = new Fraction(7, 30);
        System.out.println(a.compareTo(b));
        Student aa = new Student("vasya", 2, 2, 2, 2, 2);
        Student bb = new Student("john", 5, 5, 5, 5, 5);
        System.out.println(aa.compareTo(bb));
    }

    public static void storageTest() {
        Storage<Integer> st1 = new Storage<>(null, 0);
        Storage<Integer> st2 = new Storage<>(99, -1);
        Storage<String> st3 = new Storage<>(null, "default");
        Storage<String> st4 = new Storage<>("hello", "hello world");
        System.out.println(st1.getItem());
        System.out.println(st2.getItem());
        System.out.println(st3.getItem());
        System.out.println(st4.getItem());
    }

    public static void boxTest() {
        Box<Supplier<String>> methodBox = new Box<>();
        Point a = new Point(2, 6);
        methodBox.putItem(a::toString);
        System.out.println(methodBox.takeItem());
    }
}