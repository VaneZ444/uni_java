package ru.bryzgalin.karate;

import lombok.Getter;

import java.util.List;

public class KarateGuy {
    @Getter
    private final String name;

    public KarateGuy(String name) {
        if (name == null) throw new IllegalArgumentException("String should not be null");
        this.name = name;
    }

    public final String kick() {
        return new Kick().strike(this);
    }

    public final String punch() {
        return new Punch().strike(this);
    }

    public final String airPunch() {
        return new AirPunch().strike(this);
    }
    public final String perform(Combo combo) {
        return combo.perform(this);
    }
}
