import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for(int i = 0; i < N; i++) {
            boolean[] bool = new boolean[26];
            String b = br.readLine();
            int count = 26;
            b = b.toLowerCase();
            for(int j = 1; j <= b.length(); j++) {
                String str = b.substring(j-1, j);
                int boop = 0;
                for(String x: abc) {
                    if(str.equals(x))
                        if(!bool[boop]) {
                            bool[boop] = true;
                            count--;
                        }
                    boop++;
                }
            }
            if(count != 0) System.out.print("missing ");
            else System.out.print("pangram");
            int boop = 0;
            for(boolean x: bool) {
                if(!x) System.out.print(abc[boop]);
                boop++;
            }
            System.out.println();
        }
    }
}
