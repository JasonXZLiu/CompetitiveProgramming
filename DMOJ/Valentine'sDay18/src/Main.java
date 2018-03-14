import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int cute = 0; int MAX = Integer.MIN_VALUE;
        for(Integer i = N; i < M && Math.min(Math.abs(M-i), Math.abs(N-i)) > MAX; i++) {
            String S = i.toString(); boolean b = true;
            for(int j = 0; j < S.length()/2; j++) {
                if(S.charAt(j) != S.charAt(S.length()-j-1)) b = false;
            }
            if(b && Math.min(Math.abs(M-i), Math.abs(N-i)) > MAX) {
                MAX = Math.min(Math.abs(M-i), Math.abs(N-i));
                cute = i;
            }
        }
        System.out.println(cute);
    }
}
