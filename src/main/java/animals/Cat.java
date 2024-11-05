package animals;

public class Cat {
    String catName;
    public Cat(String catName){
        this.catName = catName;
    }
    public String meow(int meowCount){
        String meowString = catName + ":meow";
        for (int i = 0; i < meowCount-1; i++) {
            meowString +="-meow";
        }
        return meowString + "!";
    }
    public String meow(){
        return this.meow(1);
    }
    @Override
    public String toString() {
        return "animals.Cat{" +
                "cat='" + catName + '\'' +
                '}';
    }
}
