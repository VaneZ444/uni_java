package ru.bryzgalin.karate;

public class Kick implements Attack{
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": бац!";
    }
}
