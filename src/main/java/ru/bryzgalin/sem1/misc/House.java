package ru.bryzgalin.sem1.misc;

public record House(int height) {
    public House {
        if (height < 1){
            throw new IllegalArgumentException("misc.House height cannot be less than 1 floor");
        }
    }
    @Override
    public String toString() {
        String phrase = "Дом с " + height + " этаж";
        if (height % 10 == 1) {
            phrase += "ом";
        } else {
            phrase += "ами";
        }
        return phrase;
    }
}