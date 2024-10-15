public class Main {
    public static void main(String[] args) {
        oneSixTen();
    }
    public static void oneSixTen(){
        City a = new City("Atkarsk", new Road(a,b,5));
        City b = new City("Belgorod",new Road(b,c,5));
        City c = new City("Kostroma",new Road(c,a,5));
        City d = new City("Dalekin", new Road(c, a, 6));
        Map map = new Map(a,b,c,d);
    }
}