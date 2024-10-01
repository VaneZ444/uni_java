public class Name {
    String firstName;
    String secondName;
    String thirdName;
    public Name(String firstName, String secondName, String thirdName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
    }
    public String sayFullName(){
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
