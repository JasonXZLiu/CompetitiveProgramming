import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine()); int E = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = S; i <= E; i++) {
            String s = Integer.toString(i);
            if(!(s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("7"))) {
                int j = 1; int length = s.length(); boolean b = false;
                while(j <= length / 2) {
                    String A = s.substring(j-1, j);
                    String B = s.substring(length-j, length-j+1);
//                    System.out.println(A + " - " + B);
                    if (A.equals("6") && B.equals("9")) {
                        b = true;
                    } else if (A.equals("9") && B.equals("6")) {
                        b = true;
                    } else if (A.equals(B) && !((A.equals("6") || (A.equals("9"))))) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                    j++;
                }
                if(s.length() % 2 == 1) {
                    if(s.substring(length/2, length/2+1).equals("6")) b = false;
                    if(s.substring(length/2, length/2+1).equals("9")) b = false;
                }
                if(b || s.equals("1") || s.equals("8")) {
                    count++;
//                    System.out.println(s);
                }
            }
        }
        System.out.println(count);
    }
}
