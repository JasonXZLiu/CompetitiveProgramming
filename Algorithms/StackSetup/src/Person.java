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
    private String key;

    Person(){}

    Person (String firstName, String lastName, int age, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentNumber = studentNumber;
        this.key = firstName + "|" + lastName + "|" + age + "|" + studentNumber;
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

    public String getKey() {
        return key;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == null) return false;
//        if (o == this) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        if (person.firstName == this.firstName && person.lastName == this.lastName && person.age == this.age && person.studentNumber == this.studentNumber) {
//            return true;
//        }
//        return false;
//    }
}
