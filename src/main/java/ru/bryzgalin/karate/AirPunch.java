package ru.bryzgalin.karate;

public class AirPunch implements Attack{
    @Override
    public String strike(KarateGuy karateGuy) {
        return karateGuy.getName()+": вжух!";
    }
}
