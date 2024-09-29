public class Name {
    String firstName;
    String secondName;
    String thirdName;
    public String sayFullName(){
        String fullName = "";
        if (firstName != null){
            fullName = fullName + " " + firstName;
        }
        if (secondName != null){
            fullName = fullName + " " + secondName;
        }
        if (thirdName != null){
            fullName = fullName + " " + thirdName;
        }
        return fullName;
    }
}
