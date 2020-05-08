import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[]args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());
        Integer D = Integer.parseInt(st.nextToken());
        Integer I = Integer.parseInt(st.nextToken());
        Integer R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer (bf.readLine());
        String x = st.nextToken();
        String y = st.nextToken();
        int [][] dp = new int [x.length() + 1][y.length() + 1];
        for(int i = 0; i <= x.length(); i++){
            for(int j = 0; j <= y.length(); j++){
                if(i == 0) dp[i][j] = I * j;
                else if(j == 0) dp[i][j] = D * i;
                else if(x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else{
                    int A = D + dp[i - 1][j];
                    int B = I + dp[i][j - 1];
                    int C = R + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(A, Math.min(B, C));
                }
            }
        }
        System.out.println(dp[x.length()][y.length()]);
    }
}