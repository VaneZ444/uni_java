public class Main {
    public static void main(String[] args) {
        oneSixTen();
    }
    public static void oneSixTen(){
        City a = new City("Atkarsk");
        City b = new City("Belgorod",new Road(a,5));
        City c = new City("Kostroma",new Road(b,5));
        City d = new City("Dalekin", new Road(c, 6));
    }
}