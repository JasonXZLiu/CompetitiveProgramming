import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/2/2018.
 */
public class AColoringProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int[][] adj = new int[R+2][C+2]; boolean b = false;
        int i = 1;
        while(!b && i <= R) {
            String S = br.readLine();
            for(int j = 1; j <= C; j++) {
                switch (S.substring(j-1, j)) {
                    case "B":
                        for(int r = i; r >= 1; r--) {
                            for(int c = j; c >= 1; c--) {
                                if(adj[r][c] == -1) b = true;
                                adj[r][c] = 1;
                            }
                        }
                        break;
                    case "R":
                        for(int r = i; r <= R; r++) {
                            for(int c = j; c <= C; c++) {
                                if(adj[r][c] == 1) b = true;
                                adj[r][c] = -1;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
        if (!b) {
            int[] col = new int[C+1];
            for(int c = 1; c <= C; c++) {
                int count = 1;
                for(int r = 1; r <= R; r++) {
                    if(adj[r][c] == 0) count++;
                }
                col[c] += count;
            }
            long total = col[1];
            for(int c = 2; c <= C; c++) total *= col[c];
            System.out.println(total);
        } else {
            System.out.println(0);
        }
    }
}
