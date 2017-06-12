import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean ifContains(int size, Person q, Stack s) {
        for (int i = 0; i < size; i++) {
            if (q.getKey() == s.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // scanner to collect input data
        Scanner sc = new Scanner(System.in);
        // size of array / class / how many people will be inputed
        int size = sc.nextInt();
        Stack s = new Stack();
        // debug value
        boolean print = true;
        for (int i = 0; i < size; i++) {
            // collect all the people inputed
            Person p = new Person();
            p.setLastName(sc.next());
            p.setFirstName(sc.next());
            p.setAge(sc.nextInt());
            p.setStudentNumber(sc.nextInt());
            s.push(p.getKey());
        }
        // person that is trying to be found
        Person q = new Person();
        q.setLastName(sc.next());
        q.setFirstName(sc.next());
        q.setAge(sc.nextInt());
        q.setStudentNumber(sc.nextInt());
        // debug statement
        if (print) {
            for (int i = 0; i < size; i++) {
                System.out.println(((Person) s.get(i)).getAge());
            }
        }
        System.out.println(ifContains(size, q, s));
    }
}
