package ru.bryzgalin.sem1.misc;

public class Name {
    private String firstName;
    private String secondName;
    private String thirdName;

    public Name(String fName, String sName, String tName) {
        if (isNullName(fName, sName, tName)) {
            throw new IllegalArgumentException("At least one name should not be empty");
        }
        setFirstName(fName);
        setSecondName(sName);
        setThirdName(tName);
    }

    public Name(String firstName, String secondName) {
        this(firstName, secondName, null);
    }

    public Name(String firstName) {
        this(firstName, null);
    }

    public Name(Name name) {
        firstName = name.firstName;
        secondName = name.secondName;
        thirdName = name.thirdName;
    }


    private boolean isNullName(String fName, String sName, String tName) {
        return !(
                !((fName == null) || fName.isEmpty()) ||
                        !((sName == null) || sName.isEmpty()) ||
                        !((tName == null) || tName.isEmpty())
        );
    }


    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private void setThirdName(String thirdName) {
        this.thirdName = thirdName;
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

    @Override
    public String toString() {
        String fullName = "";
        if (firstName != null) {
            fullName = fullName + " " + firstName;
        }
        if (thirdName != null) {
            fullName = fullName + " " + thirdName;
        }
        if (secondName != null) {
            fullName = fullName + " " + secondName;
        }
        return fullName;
    }

}
