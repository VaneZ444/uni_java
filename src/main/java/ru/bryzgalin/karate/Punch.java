package ru.bryzgalin.karate;

public class Punch implements Attack{
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": кия!";
    }
}
