import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AStringProblem {

    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] adj = new int[26];
        String S = br.readLine();
        for(int i = 0; i < S.length(); i++) {
            adj[abc.indexOf(S.substring(i, i+1))]++;
        }
        Arrays.sort(adj);
        System.out.println(S.length() - (adj[25] + adj[24]));
    }
}
