import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int K = in.nextInt(), cnt = 0;
        ArrayList<E> e = new ArrayList<E>();
        for (int v = 5000; v >= 2; v--) {
            while(v * (v-1) / 2 <= K) {
                int st = cnt+1, ed = cnt + v;
                if(cnt!= 0) e.add(new E(cnt, st));
                for(int j = st; j < ed; j++)
                    e.add(new E(j, j + 1));
                e.add(new E(ed, st));
                K -= v * (v-1) / 2; cnt = ed;
            }
        }
        System.out.println(cnt + " " + e.size());
        for(E each: e) System.out.println(each.u + " " + each.v);
    }

    static class E{
        int u, v;
        E(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}

