package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class NamesScores {
    public static String[] abc = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String name = br.readLine().toLowerCase();
            int j = 0; int sum = 0;
            while(j < name.length()) {
                int k = 0;
                while(!abc[k].equals(name.substring(j, j+1))) {
                    k++;
                }
                sum += (k+1);
                j++;
            }
            names[i-1] = name;
            map.put(name, sum);
        }
        Arrays.sort(names);
        for(int i = 0; i < N; i++) {
            map.replace(names[i], map.get(names[i]), map.get(names[i]) * (i+1));
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String S = br.readLine().toLowerCase();
            System.out.println(map.get(S));
        }
    }
}
