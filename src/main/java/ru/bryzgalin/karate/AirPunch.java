package ru.bryzgalin.karate;

public class AirPunch implements Action{
    @Override
    public void act(KarateKid karateKid) {
        karateKid.airPunch();
    }
}
