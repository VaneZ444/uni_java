package ru.bryzgalin.main;

import ru.bryzgalin.animals.*;
import ru.bryzgalin.interfaces.Meowable;
import ru.bryzgalin.misc.dataStream.DataStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("john");
        DogCat dc = new DogCat();
        test(fakeCat);
        System.out.println(fakeCat);
    }
    public static void test(Meowable m){
        m.meow();
        m.meow();
        m.meow();
        m.meow();
    }
}