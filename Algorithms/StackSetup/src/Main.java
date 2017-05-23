import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean ifContains(Stack s, Person p, int size) {
        // WHERE THE EQUAL OPERATOR SHOULD GO
        return false;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Stack s = new Stack();
        boolean print = true;
        for (int i = 0; i < size; i++) {
            Person p = new Person();
            p.setLastName(sc.next());
            p.setFirstName(sc.next());
            p.setAge(sc.nextInt());
            p.setStudentNumber(sc.nextInt());
            s.push(p);
        }
        Person q = new Person();
        q.setLastName(sc.next());
        q.setFirstName(sc.next());
        q.setAge(sc.nextInt());
        q.setStudentNumber(sc.nextInt());
        if (print) {
            for (int i = 0; i < size; i++) {
                System.out.println(s.get(i));
            }
        }
        System.out.println(ifContains(s, q, size));
    }
}
