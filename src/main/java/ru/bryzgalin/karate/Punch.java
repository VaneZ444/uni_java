package ru.bryzgalin.karate;

public class Punch implements Action{
    @Override
    public void act(KarateKid karateKid) {
        karateKid.punch();
    }
}
