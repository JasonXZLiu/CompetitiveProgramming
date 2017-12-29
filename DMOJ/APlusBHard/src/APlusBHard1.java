import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/14/2017.
 */
public class APlusBHard1 {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(A.contains("-") && B.contains("-")) {
                A = A.replace("-", "");
                B = B.replace("-", "");
                add(A, B, false);
            }
            else if(A.contains("-")) {
                A = A.replace("-", "");
                int tmp = checkLarger(A, B);
                if(tmp == 1) {
                    subtract(A, B, "-");
                } else if (tmp == 0) {
                    System.out.print(0);
                } else {
                    subtract(B, A, "");
                }
            } else if(B.contains("-")) {
                B = B.replace("-", "");
                int tmp = checkLarger(A, B);
                if(tmp == 1) {
                    subtract(A, B, "");
                } else if (tmp == 0) {
                    System.out.print(0);
                } else {
                    subtract(B, A, "-");
                }
            }
            else {
                A = A.replace("-", "");
                B = B.replace("-", "");
                add(A, B, true);
            }
            System.out.println();
        }
    }

    public static void reverse(String tmp, String extra, String ans) {
        System.out.print(ans + extra);
        boolean zero = true;
        for(int i = tmp.length(); i >= 1; i--) {
            int boop = Integer.parseInt(tmp.substring(i-1, i));
            if(boop == 0 && zero);
            else {
                zero = false;
                System.out.print(boop);
            }
        }
    }

    public static int checkLarger(String A, String B) {
        if(A.length() > B.length()) return 1;
        else if (A.length() < B.length()) return -1;
        else {
            int i = 0;
            while (i < B.length()) {
                int a = Integer.parseInt(A.substring(i, i + 1));
                int b = Integer.parseInt(B.substring(i, i + 1));
                if (b > a) return -1;
                else if (a > b) return 1;
                i++;
            }
            return 0;
        }
    }

    public static void subtract(String A, String B, String str) {
        String tmp = ""; int carry = 0; String extra = "";
        int i = 1; int aL = A.length(); int bL = B.length();
        while(i <= bL && i <= aL) {
            int a = Integer.parseInt(A.substring(aL - i, aL - i + 1));
            int b = Integer.parseInt(B.substring(bL - i, bL - i + 1));
            Integer X = (a - carry) - b;
            if (X < 0) {
                carry = (X / 10) + 1;
                X = X + 10;
            } else carry = 0;
            tmp += X;
            i++;
        }
        if (bL > aL) {
            extra += Long.parseLong(B.substring(0, bL - i)) - carry;
        } else if (aL > bL) {
            extra += Long.parseLong(A.substring(0, aL - i)) - carry;
        }
        reverse(tmp, extra, str);
    }

    public static void add(String A, String B, boolean negative) {
        String tmp = ""; int carry = 0; String extra = "";
        int i = 1; int aL = A.length(); int bL = B.length();
        while(i <= bL && i <= aL) {
            int a = Integer.parseInt(A.substring(aL - i, aL - i + 1));
            int b = Integer.parseInt(B.substring(bL - i, bL - i + 1));
            Integer X = a + b + carry;
            if(X >= 10) {
                carry = X / 10;
                X = X % 10;
            }
            else carry = 0;
            tmp += X;
            i++;
        }
        i--;
        if(carry != 0) extra += carry;
        if (bL > aL) {
            extra += Long.parseLong(B.substring(0, bL - i)) + carry;
        } else if (aL > bL) {
            extra += Long.parseLong(A.substring(0, aL - i)) + carry;
        }
        String ans = "";
        if(!negative) ans = "-";
        reverse(tmp, extra, ans);
    }
}
