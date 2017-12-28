import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BigSorting {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        E[] arr = new E[N];
        for(int i = 0; i < N; i++) arr[i] = new E(br.readLine());
        Arrays.sort(arr);
        for(E s: arr) System.out.println(s.str);
    }

    static class E implements Comparable<E> {
        public String str;

        E(String str) {this.str = str;}

        @Override
        public int compareTo(E o) {
            if(o.str.length() > str.length()) return -1;
            else if(o.str.length() < str.length()) return 1;
            else {
                int i = 0;
                while(i < str.length()) {
                    if(Integer.parseInt(o.str.substring(i, i+1)) > Integer.parseInt(str.substring(i, i+1))) return -1;
                    else if (Integer.parseInt(o.str.substring(i, i+1)) < Integer.parseInt(str.substring(i, i+1))) return 1;
                    i++;
                }
                return 0;
            }
        }
    }
}
