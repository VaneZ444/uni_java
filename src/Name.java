public class Name {
    final String firstName;
    final String secondName;
    final String thirdName;

    public Name(String firstName, String secondName, String thirdName){
        if(firstName.isBlank() || secondName.isBlank() || thirdName.isBlank()){
            throw new IllegalArgumentException("At least one nameField should not be empty");
        }
        setFirstName(firstName);
        setSecondName(secondName);
        setThirdName(thirdName);
    }
    public Name(String firstName){
        this(firstName, null);
    }
    public Name(String firstName, String secondName){
        this(firstName,secondName,null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
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
