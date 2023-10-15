package _6_Exercises_DefiningClasses._07_Google;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.parentName, this.parentBirthday);
    }
}
