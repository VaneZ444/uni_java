package ru.bryzgalin.main;

import ru.bryzgalin.mathematical.Line;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.misc.Human;
import ru.bryzgalin.reflections.ReflectionUtils;
import ru.bryzgalin.reflections.Entity;
import ru.bryzgalin.reflections.readerWriter.ObjectsReader;
import ru.bryzgalin.reflections.readerWriter.ObjectsWriter;
import ru.bryzgalin.reflections.validation.HumanTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.bryzgalin.reflections.validation.ValidationUtils.validate;

public class Main {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
        //test4();
    }

    public static void test1() {
        Line line1 = Line.of(new Point(1, 1), new Point(2, 2));
        Line line2 = Line.of(new Point(3, 3), new Point(4, 4));
        System.out.println(line1);
        System.out.println(line2);
        try {
            ReflectionUtils.lineConnector(line1, line2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // Выводим результат
        System.out.println(line1);
        System.out.println(line2);

    }
    public static void test2() {
        class A extends Entity{
            String s = "Hello";
            int x=42;
        }
        class B extends A{
            String text = "B";
        }
        B b = new B();
        System.out.println(b);
    }
    public static void test3() {
        ru.bryzgalin.misc.Human h = new ru.bryzgalin.misc.Human("Sergey", 750);
        System.out.println(h);
            validate(h, HumanTests.class);

        /*
        Должно вывести Exception in thread "main" ValidateException:
        ошибка в test5: возраст человека не в диапазоне от 1 до 200
         */
    }
    public static void test4(){
        List<Human> people = new ArrayList<>();
        people.add(new Human("sergey 30"));
        people.add(new Human("oleg 25"));

        try {
            ObjectsWriter writer = new ObjectsWriter("people.txt");
            writer.write(people);

            ObjectsReader<Human> reader = new ObjectsReader<>("people.txt", Human.class);
            List<Human> readPeople = reader.read();

            for (Human human : readPeople) {
                System.out.println(human);
            }
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}