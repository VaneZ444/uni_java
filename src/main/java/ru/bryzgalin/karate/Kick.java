package ru.bryzgalin.karate;

public class Kick implements Attacker {
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": бац!";
    }
}
