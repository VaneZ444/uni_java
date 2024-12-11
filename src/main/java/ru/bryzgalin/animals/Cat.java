package ru.bryzgalin.animals;

import lombok.Getter;
import ru.bryzgalin.interfaces.Meowable;

public class Cat implements Meowable {
    @Getter
    private String catName;
    public Cat(String catName){
        this.setCatName(catName);
    }
    public String meowStr(int meowCount){
        String meowString = getCatName() + ":meow";
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
                "cat='" + getCatName() + '\'' +
                '}';
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
