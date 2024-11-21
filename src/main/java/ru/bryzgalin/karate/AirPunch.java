package ru.bryzgalin.karate;

public class AirPunch implements Attacker {
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": вжух!";
    }
}
