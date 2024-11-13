package ru.bryzgalin.animals;

import ru.bryzgalin.interfaces.Meowable;

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
    public void meow() {
        System.out.println("mreow");
    }
}
