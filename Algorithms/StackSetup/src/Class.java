import java.util.ArrayList;

/**
 * Created by jason_001 on 5/23/2017.
 */
public class Class {
    private ArrayList hsClass;
    private int size;

    Class(int size) {
        hsClass = new ArrayList(size);
    }

    public void addStudents(Person p) {
        hsClass.add(p);
    }

    public int getSize() {
        return size;
    }

    public static boolean ifContains(ArrayList a, Person p, int size) {
        for (int i = 0; i < size; i++) {
            if (a.get(i) == p) {
                return true;
            }
        }
        return false;
    }
}
