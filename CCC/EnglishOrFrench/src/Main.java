import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cntT = 0; int cntS = 0;
        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            for(int j = 1; j <= S.length(); j++) {
                String str = S.substring(j-1, j);
                switch (str) {
                    case "t":
                        cntT++;
                        break;
                    case "T":
                        cntT++;
                        break;
                    case "S":
                        cntS++;
                        break;
                    case "s":
                        cntS++;
                        break;
                    default:
                        break;
                }
            }
        }
        if(cntT > cntS) System.out.println("English");
        else System.out.println("French");
    }
}
