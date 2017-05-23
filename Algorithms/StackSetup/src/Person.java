import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jason_001 on 5/23/2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int studentNumber;

    Person(){}

    Person(String firstName, String lastName, int age, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
