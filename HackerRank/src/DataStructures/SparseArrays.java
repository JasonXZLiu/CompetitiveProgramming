package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            if(!map.containsKey(S)) map.put(S, 1);
            else {
                int cnt = map.remove(S) + 1;
                map.put(S, cnt);
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String S = br.readLine();
            System.out.println((map.containsKey(S)) ? map.get(S): "0");
        }
    }
}
