package ru.bryzgalin.karate;

public class Punch implements Attacker {
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": кия!";
    }
}
