import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        int[] lis = new int[N];
        for(int i = 0; i < N; i++) lis[i] = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(x[i] > x[j]) lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }
        int MAX = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            MAX = Math.max(MAX, lis[i]);
        }
        System.out.println(MAX);
    }
}
