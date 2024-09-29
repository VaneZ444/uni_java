public class House {
    int height;
    public String houseInfo(){
        String phrase = "Дом с " + height + " этаж";
        if (height%10 == 1){
            phrase+="ом";
        } else {
            phrase+="ами";
        }
        return phrase;
    }
}