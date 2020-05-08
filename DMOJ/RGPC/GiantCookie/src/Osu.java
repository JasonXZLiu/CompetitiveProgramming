import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/13/2018.
 */
public class Osu {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); double old = Double.parseDouble(st.nextToken());
        int womboCombo = 0; int count = 0;
        int exc = 0; int gre = 0; int good = 0; int bad = 0; int miss = 0;
        for(int i = 0; i < N; i++) {
            int A = Math.abs(Integer.parseInt(br.readLine()));
            if(50 >= A) {exc++; count++;}
            else if(100 >= A) {gre++; count++;}
            else if(150 >= A) {good++; count++;}
            else if(200 >= A) {bad++; count++;}
            else {miss++; womboCombo = Math.max(womboCombo, count); count = 0;}
        }
        womboCombo = Math.max(womboCombo, count);
        double newScore = 1.5 * exc + gre + good + 0.5 * bad - miss + 0.5 * womboCombo;
        if((double) Math.round((newScore - old) * 10) / 10 <= 0) System.out.println("0.0");
        else System.out.println((double) Math.round((newScore - old) * 10) / 10);
    }
}