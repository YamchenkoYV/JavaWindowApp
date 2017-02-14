/**
 * Created by Юрий on 05.09.2016.
 */
public class Person {
    private String firstName;
    private String secondName;
    private String lastName;

    public Person(String fName, String sName, String lName){
        firstName = fName;
        secondName = sName;
        lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
