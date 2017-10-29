import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int[][] N = new int[9][9];
        int blah = 1;
        for(int i = 1; i < 8; i++) {
            String a = in.nextLine();
            if(a.length() == 3) {
                blah = 3;
            }
            int blah2 = 0;
            for(int k = blah; k <= a.length(); k++) {
                String b = a.substring(blah2, blah2+1);
                if(b.equals(".")) {
                    N[i][k] = 2;
                } else if (b.equals("o"))  {
                    N[i][k] = 1;
                }
                blah2++;
            }
            blah = 1;
        }
        int cnt = 0;
        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= 8; j++) {
                if(N[i][j] == 2) {
                    if(N[i][j - 1] == 1 && N[i][j - 2] == 1 ) {
                        cnt++;
                    }
                    if(N[i][j + 1] == 1 && N[i][j + 2] == 1) {
                        cnt++;
                    }
                    if(N[i - 1][j] == 1 && N[i - 2][j] == 1) {
                        cnt++;
                    }
                    if(N[i + 1][j] == 1 && N[i + 2][j] == 1) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}