import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/14/2018.
 */
public class S2 {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N+2][N+2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean b = true;
        for(int i = 1; i <= N && b; i++) {
            if(!(table[i][1] > table[i-1][1])) b = false;
            for(int j = 1; j <= N; j++)
                if(!(table[i][j] > table[i][j-1])) b = false;
        }
        if(b) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    System.out.print(table[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            b = true;
            for(int i = N; i >= 1 && b; i--) {
                if(!(table[1][i] < table[1][i-1]) && i - 1 != 0) b = false;
                for(int j = 1; j <= N; j++) {
                    if (!(table[j][i] > table[j - 1][i])) b = false;
                }
            }
            if(b) {
                for(int i = N; i >= 1; i--) {
                    for(int j = 1; j <= N; j++) {
                        System.out.print(table[j][i] + " ");
                    }
                    System.out.println();
                }
            } else {
                b = true;
                for(int i = N; i >= 1 && b; i--) {
                    if(!(table[N][i] > table[N][i-1])) b = false;
                    for(int j = N; j > 1; j--) {
                        if (!(table[j][i] < table[j - 1][i])) b = false;
                    }
                }
                if(b) {
                    for(int i = 1; i <= N; i++) {
                        for(int j = N; j >= 1; j--) {
                            System.out.print(table[j][i] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    for(int i = N; i >= 1; i--) {

                        for(int j = N; j >= 1; j--) {
                            System.out.print(table[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
