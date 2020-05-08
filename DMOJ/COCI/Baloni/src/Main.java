import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[10000001]; int count = 0;
        ArrayList<Integer> adj = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            if(num[X+1] != 0) {
                num[X+1]--;
                num[X]++;
            } else {
                num[X]++;
                count++;
            }
        }
        System.out.println(count);
    }
}
