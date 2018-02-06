import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[1000001], lis = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) x[Integer.parseInt(st.nextToken())] = i;
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 1; i <= M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(x[tmp] == 0) continue;
                if(count == 0 || x[tmp] > lis[count - 1]) lis[count++] = x[tmp];
                else {
                    int idx = Arrays.binarySearch(lis, 0, count, x[tmp]);
                    lis[-(idx+1)] = x[tmp];
                }
        }
        System.out.println(count);
    }
}