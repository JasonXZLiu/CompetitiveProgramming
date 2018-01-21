import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[]args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        Integer t = Integer.parseInt(bf.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer (bf.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer k = Integer.parseInt(st.nextToken());
            Integer w = Integer.parseInt(st.nextToken());
            long [] ai = new long [n];
            for(int j = 0; j < n; j++) ai[j] = Integer.parseInt(bf.readLine());
            int [][] dp = new int [k + 1][n + 1];
            for(int j = 1; j <= k; j++){
                for(int l = 1; l <= n; l++){
                    if(l <= w){
                        for(int m = 0; m < l; m++) dp[j][l] += ai[m];
                    }
                    else{
                        int sum = 0;
                        for(int m = l - 1; m > l - 1 - w; m--){
                            sum += ai[m];
                        }
                        dp[j][l] = Math.max(dp[j - 1][l], Math.max(dp[j][l - 1], sum + dp[j - 1][l - w]));
                    }
//                    System.out.print(dp[j][l] + " ");
                }
//                System.out.println();
            }
            System.out.println(dp[k][n]);
        }

    }
}