package animals;

import interfaces.Meowable;

public class Cat implements Meowable {
    String catName;
    public Cat(String catName){
        this.catName = catName;
    }
    public String meowStr(int meowCount){
        String meowString = catName + ":meow";
        for (int i = 0; i < meowCount-1; i++) {
            meowString +="-meow";
        }
        return meowString + "!";
    }
    public String meowStr(){
        return this.meowStr(1);
    }
    @Override
    public void meow() {
        System.out.println("meow");
    }
    @Override
    public String toString() {
        return "animals.Cat{" +
                "cat='" + catName + '\'' +
                '}';
    }

}
