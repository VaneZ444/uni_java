public record House(int height) {
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