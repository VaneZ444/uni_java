public class Human {
    Name humanName;
    int height;
    Human father;
    public Human(Name humanName, int height, Human father){
        this.father = father;
        this.humanName = humanName;
        this.height = height;
    }
    public String introduce(){
        if (this.father != null){
            if (this.humanName.thirdName == null) {
                this.humanName.thirdName = this.father.humanName.firstName + "ovych";
            }
            if (this.humanName.secondName == null) {
                this.humanName.secondName = this.father.humanName.secondName;
            }
        }
        return humanName.sayFullName() + ", " + "height: " + height;
    }
}
