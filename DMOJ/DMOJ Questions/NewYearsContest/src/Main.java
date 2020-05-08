import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long H = Long.parseLong(st.nextToken()); long M = Long.parseLong(st.nextToken()); long S = Long.parseLong(st.nextToken());
        M += S / 60;
        S %= 60;
        H += M / 60;
        M %= 60;
        if(S > 0) M++;
        if(M > 0) H++;
        H %= 12;
        long ansH = 12 - H;
        long ansM = 60 - M;
        long ansS = 60 - S;
        if (ansH == 12) System.out.print("00:");
        else if (ansH >= 10) System.out.print(ansH + ":");
        else System.out.print("0" + ansH + ":");
        if(M == 60 || M == 0) System.out.print("00:");
        else if(ansM < 10) System.out.print("0" + ansM +":");
        else System.out.print(ansM + ":");
        if(S == 60 || S == 0) System.out.print("00");
        else if(ansS < 10) System.out.print("0" + ansS);
        else System.out.print(ansS);
    }
}
