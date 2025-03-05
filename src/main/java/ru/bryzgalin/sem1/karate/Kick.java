package ru.bryzgalin.sem1.karate;

public class Kick implements Action{
    @Override
    public void act(KarateKid karateKid) {
        karateKid.kick();
    }
}
