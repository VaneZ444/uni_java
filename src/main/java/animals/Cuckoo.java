package animals;

import interfaces.Meowable;

public class Cuckoo extends Bird {
    public Cuckoo(String name) {
        super(name);
    }
    public String sing() {
        String str = "";
        int times = (int) (Math.random() * 9) + 1;
        for (int i = 0; i < times; i++) str += " cuckoo";
        return str;
    }

}
