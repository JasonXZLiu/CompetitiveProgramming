import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cups {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int[] pre = new int[N+1];
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pre[A] += C;
            if(B < N) pre[B+1] -= C;
        }
        for(int i = 1; i <= N; i++) pre[i] = pre[i-1] + pre[i];
        int L = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 1; i <= N;) {
            int j = i; int total = 0; int cnt = 0;
            while(j <= N && total + pre[j] <= L) {
                total += pre[j]; cnt++; j++;
            }
            i = j + 1;
            count = Math.max(count, cnt);
        }
        System.out.println(count);
    }
}
