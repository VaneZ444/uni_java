package ru.bryzgalin.spring;

public class Review {
    private final String text;
    private final int rating;

    public Review(String text, int rating) {
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Отзыв: \"" + text + "\", Оценка: " + rating;
    }
}