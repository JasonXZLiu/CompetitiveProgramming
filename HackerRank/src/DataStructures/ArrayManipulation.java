package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[] adj = new long[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken())-1, Y = Integer.parseInt(st.nextToken());
            long Z = Long.parseLong(st.nextToken());
            adj[X] += Z;
            if(Y < N) adj[Y] -= Z;
//            System.out.println(X + "-" + Y);
        }
        long MAX = adj[0];
        for(int i = 1; i < N; i++) {
            adj[i] = adj[i] + adj[i-1];
            MAX = Math.max(MAX, adj[i]);
        }
        System.out.println(MAX);
    }
}
