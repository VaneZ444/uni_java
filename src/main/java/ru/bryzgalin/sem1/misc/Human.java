package ru.bryzgalin.sem1.misc;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Human(String params) {
        String[] parts = params.split(" ");
        this.name = parts[0];
        this.age = Integer.parseInt(parts[1]);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}