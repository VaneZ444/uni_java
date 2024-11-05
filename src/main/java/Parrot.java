public class Parrot extends Bird{
    String text;
    public Parrot(String name, String text) {
        super(name);
        this.text = text;
    }
    public String sing() {
        String str = "";
        int strLen = (int) (Math.random() * text.length());
        str = text.substring(0,strLen);
        return " " + str;
    }
}
