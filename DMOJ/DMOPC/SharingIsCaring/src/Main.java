import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
            if(map.containsKey(B)) map.put(B, map.get(B) + "///" + br.readLine());
            else map.put(B, br.readLine());
        }
        int X = Integer.parseInt(br.readLine());
        String ansString = "";
        if(map.containsKey(X)) ansString = map.get(X);
        String[] ans = ansString.split("///");
        for(String x: ans) System.out.println(x);
    }
}
