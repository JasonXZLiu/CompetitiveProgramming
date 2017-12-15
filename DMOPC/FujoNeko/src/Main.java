import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); int C = Integer.parseInt(st.nextToken());
        boolean[] row = new boolean[R];
        boolean[] col = new boolean[C];
        for(int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < C; j++) {
                String s = tmp.substring(j, j+1);
                switch (s) {
                    case "X":
                        row[i] = true;
                        col[j] = true;
                        break;
                    default:
                        break;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken())-1; int Y = Integer.parseInt(st.nextToken())-1;
            if(col[X]) count++;
            if(row[Y]) count++;
            if(count != 0) System.out.println("Y");
            else System.out.println("N");
        }
    }
}
