package misc;

public class Human {
    private final Name humanName;
    private int height;
    private final Human humanFather;

    public Human(Name humanName, int height, Human humanFather) {
        this.humanName = constructName(humanName, humanFather);
        this.humanFather = humanFather;
        setHeight(height);
    }

    public Human(Name humanName, int height) {
        this(humanName, height, null);
    }

    public Human(String firstNameString, int height) {
        this(new Name(firstNameString), height);
    }

    public Human(String firstNameString, int height, Human humanFather) {
        this(new Name(firstNameString), height, humanFather);
    }

    private boolean isValidHeight(int h) {
        return (h <= 500) && (h >= 0);
    }

    private Name constructName(Name humanName, Human humanFather) {

        String tempFirst = humanName.getFirstName();
        String tempSecond = humanName.getSecondName();
        String tempThird = humanName.getThirdName();

        String tempSecondF = "";
        String tempThirdF = "";

        if(humanFather != null) {
            Name fatherName = humanFather.getName();
            tempSecondF = fatherName.getSecondName();
            tempThirdF = fatherName.getThirdName();
        }

        if (((tempSecond == null) || tempSecond.isEmpty())) {
            if (!((tempSecondF == null) || tempSecondF.isEmpty())) {
                tempSecond = tempSecondF;
            }
        }
        if (((tempThird == null) || tempThird.isEmpty())) {
            if (!((tempThirdF == null) || tempThirdF.isEmpty())) {
                tempThird = tempThirdF;
            }
        }

        return new Name(tempFirst, tempSecond, tempThird);
    }

    public void setHeight(int height) {
        if (!isValidHeight(height)) {
            throw new IllegalArgumentException("Height value should be between 0 and 500");
        }
        this.height = height;
    }

    public Human getFather() {
        return humanFather;
    }

    public int getHeight() {
        return height;
    }

    public Name getName() {
        return new Name(humanName);
    }

    @Override
    public String toString() {
        return "misc.Human{" +
                "humanName=" + humanName +
                ", height=" + height +
                ", humanFather=" + humanFather +
                '}';
    }
}