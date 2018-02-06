import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/5/2018.
 */
public class ASegmentTreeProblem {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] adj = new int[2000001];
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "ADD":
                    int K = Integer.parseInt(st.nextToken());
                    int P = Integer.parseInt(st.nextToken());
                    adj[P] += K;
                    break;
                case "ADDRANGE":
                    int A = Integer.parseInt(st.nextToken());
                    int B = Integer.parseInt(st.nextToken());
                    for(int i = A; i <= B; i++) {
                        adj[i]++;
                    }
                    break;
                case "BUYAMT":
                    long tot = 0; int i = 0;
                    long Q = Long.parseLong(st.nextToken());
                    while(tot + adj[i] * i <= Q) {
                        tot += adj[i];
                        i++;
                    }
                    tot += (long) Math.floor((tot - Q) / i) * adj[i];
                    System.out.println(tot);
                    break;
                case "BUYLOW":
//                    int cnt = 0; tot = 0; i = 0;
//                    int L = Integer.parseInt(st.nextToken());
//                    while(cnt <= L && i < 2000001) {
//                        if(adj[i] != 0) {
//                            tot += i*adj[i];
//                            adj[i] = 0;
//                        }
//                        cnt++; i++;
//                    }
//                    System.out.println(tot);
                    break;
                case "BUYHIGH":
//                    cnt = 0; tot = 0; i = 2000000;
//                    L = Integer.parseInt(st.nextToken());
//                    while(cnt <= L && i >= 0) {
//                        if(adj[i] != 0) {
//                            tot += i*adj[i];
//                            adj[i] = 0;
//                        }
//                        cnt++; i--;
//                    }
//                    System.out.println(tot);
                    break;
                case "COST":
                    System.out.println(-1);
                    break;
                case "NUMCONES":
                    long num = 0;
                    for(int j = 0; j < 2000001; j++) {
                        if(adj[j] != 0) num += adj[j];
                    }
                    System.out.println(num);
                    break;
                default:
                    num = 0;
                    for(int j = 0; j < 2000001; j++) {
                        if(adj[j] != 0) num += j;
                    }
                    System.out.println(num);
                    break;
            }
        }
    }
}
