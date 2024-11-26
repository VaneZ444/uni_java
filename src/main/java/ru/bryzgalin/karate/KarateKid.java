package ru.bryzgalin.karate;

import lombok.Getter;

public class KarateKid {
    @Getter
    private final String name;

    public KarateKid(String name) {
        if (name == null) throw new IllegalArgumentException("String should not be null");
        this.name = name;
    }

    public void kick() {
        System.out.println(name + ": kyo!");
    }

    public void punch() {
        System.out.println(name + ": kya!");
    }

    public void airPunch() {
        System.out.println(name + ": vhoosh!");
    }
}
