public class Human {
    Name humanName;
    int height;
    Human humanFather;

    public Human(Name humanName, int height, Human humanFather){
        this.humanName = humanName;
        this.height = height;
        this.humanFather = humanFather;
        if(this.humanFather != null){
            if ((this.humanName.thirdName == null)&&(this.humanFather.humanName.thirdName != null)){this.humanName.thirdName = this.humanFather.humanName.thirdName;}
            if ((this.humanName.secondName == null)&&(this.humanFather.humanName.secondName != null)){this.humanName.secondName = this.humanFather.humanName.secondName;}
        }
    }

    public Human(Name humanName, int height){
        this(humanName, height,null);
    }
    public Human(String firstNameString, int height){
        this(new Name(firstNameString), height);
    }
    public Human(String firstNameString, int height, Human humanFather){
        this(new Name(firstNameString), height, humanFather);
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanName=" + humanName +
                ", height=" + height +
                ", humanFather=" + humanFather +
                '}';
    }
}