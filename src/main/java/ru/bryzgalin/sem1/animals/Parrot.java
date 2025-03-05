package ru.bryzgalin.sem1.animals;

import ru.bryzgalin.annotations.Invoke;
import ru.bryzgalin.sem1.interfaces.Meowable;

public class Parrot extends Bird implements Meowable {
    String text;
    public Parrot(String name, String text) {
        super(name);
        this.text = text;
    }
    public Parrot(String name) {
        this(name,"caw-caw");
    }
    public String sing() {
        String str = "";
        int strLen = (int) (Math.random() * text.length());
        str = text.substring(0,strLen);
        return " " + str;
    }

    @Override
    @Invoke
    public void meow() {
        System.out.println("mreow");
    }
}
