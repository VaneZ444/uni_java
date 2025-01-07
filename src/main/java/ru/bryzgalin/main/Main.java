package ru.bryzgalin.main;

import ru.bryzgalin.mathematical.CachedSquare;
import ru.bryzgalin.mathematical.Square;

public class Main {
    public static void main(String[] args) {
        Square a = new Square(2,2,4);
        a = new CachedSquare(a);
        System.out.println(a.square());
        System.out.println(a.square());
        a.setSide(5);
        System.out.println(a.square());
        System.out.println(a.square());
    }
}