package ru.bryzgalin.karate;

public class Kick implements Action{
    @Override
    public void act(KarateKid karateKid) {
        karateKid.kick();
    }
}
