public record House(int height) {
    public House {
        if (height < 1){
            throw new IllegalArgumentException("House height cannot be less than 1 floor");
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