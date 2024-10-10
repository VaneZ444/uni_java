public class Human {
    Name humanName;
    int height;
    Human humanFather;

    public Human(Name humanName, int height, Human humanFather){
        this.humanName = humanName;
        this.height = height;
        this.humanFather = humanFather;
        if(this.humanFather != null){
            if ((this.humanName.getThirdName() == null)&&(this.humanFather.humanName.getThirdName() != null)){this.humanName = new Name(this.humanName.getFirstName,this.humanName.getSecondName,this.humanFather.humanName.getThirdName());}
            if ((this.humanName.getSecondName() == null)&&(this.humanFather.humanName.getSecondName() != null)){this.humanName = new Name(this.humanFather.humanName.getThirdName() != null)){this.humanName = new Name(this.humanName.getFirstName,this.humanFather.humanName.getSecondName,this.humanName.getThirdName());}
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
