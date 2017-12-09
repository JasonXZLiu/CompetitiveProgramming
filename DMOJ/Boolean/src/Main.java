import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken(); boolean b = true; int cnt = 0;
        while(!(str.equals("True") || str.equals("False"))) {
            str = st.nextToken();
            cnt ++;
            b = !b;
        }
        if(str.equals("False")) b = !b;
        if(b && cnt != 0) System.out.println("True");
        else if (cnt == 0) System.out.println(str);
        else System.out.println("False");
    }
}
