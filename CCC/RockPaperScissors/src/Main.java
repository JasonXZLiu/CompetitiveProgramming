import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/25/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = new String[N];
        for(int i = 0; i < N; i++) {
            s[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine()); int A = 0; int B = 0;
        for(int i = 0; i < N; i++) {
            String tmp = st.nextToken();
            if(s[i].equals(tmp));
            else {
                if(s[i].equals("rock") && tmp.equals("scissors")) A++;
                else if(s[i].equals("scissors") && tmp.equals("paper")) A++;
                else if(s[i].equals("paper") && tmp.equals("rock")) A++;
                else B++;
            }
        }
        System.out.println(A + " " + B);
    }
}
