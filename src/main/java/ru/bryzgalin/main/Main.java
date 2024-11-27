package ru.bryzgalin.main;

import ru.bryzgalin.animals.Parrot;
import ru.bryzgalin.mathematical.Fraction;
import ru.bryzgalin.mathematical.Point;
import ru.bryzgalin.mathematical.VolumetricPoint;
import ru.bryzgalin.misc.*;
import ru.bryzgalin.weaponry.Pistol;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum(new ArrayList<>()).getItem(-1)-10);
    }
    public static Storage<Integer> sum(List<Integer> lst) {
        if(lst.isEmpty()) return Storage.empty();
        int sum = 0;
        for (Integer integer : lst) {
            sum += integer;
        }
        return Storage.of(sum);
    }
}