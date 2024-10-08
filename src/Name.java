public class Name {
    String firstName;
    String secondName;
    String thirdName;
    public Name(String firstName, String secondName, String thirdName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
    }
    public Name(String firstName){
        this(firstName, null);
    }
    public Name(String firstName, String secondName){
        this(firstName,secondName,null);
    }
    @Override
    public String toString(){
        String fullName = "";
        if (firstName != null){
            fullName = fullName + " " + firstName;
        }
        if (thirdName != null){
            fullName = fullName + " " + thirdName;
        }
        if (secondName != null){
            fullName = fullName + " " + secondName;
        }
        return fullName;
    }
}
