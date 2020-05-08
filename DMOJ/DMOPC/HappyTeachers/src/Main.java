import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] save = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            save[i][0] = Integer.parseInt(st.nextToken());
            save[i][1] = Integer.parseInt(st.nextToken());
            save[i][2] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        int[] dur = new int[N+1];
        int[][] ans = new int[T+1][N+1];
        for(int i = 1; i <= N; i++) {
            int H = save[i][0], E = save[i][1], P = save[i][2];
            int sum = H; int sumP = P;
            while(H > 0 && T - sumP - ans[T][i-1] >= 0) {
                System.out.println(sumP);
                dur[i]++;
                for(int j = 1; j <= T; j++) {
                    if(j - sumP >= 0) {
                        ans[j][i] = Math.max(ans[j][i - 1], ans[j][i]);
                        if(ans[j-sumP][i - 1] + sum > ans[j][i]) {
                            ans[j][i] = ans[j-sumP][i - 1] + sum;
                        }
                    }
                    else ans[j][i] =  Math.max(ans[j][i - 1], ans[j][i]);
                }
                H -= E;
                sum += H;
                sumP += P;
            }
        }
        for(int i = 0; i <= N; i++) System.out.print(dur[i] + " ");
        System.out.println();
        int sum = 0; int idx = T;
        for(int i = N; i >= 0 && idx >= 0; i--) {
            if(ans[idx][i] != ans[idx-1][i]) {
                System.out.println(dur[i]);
                sum += dur[i]; idx--;
            }
        }
        System.out.println(ans[T][N]);
        System.out.println(sum);
    }
}
