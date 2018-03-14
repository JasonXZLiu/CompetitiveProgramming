import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        String A = br.readLine();
        if(A.equals("N") && M * 5 <= N) System.out.println("A");
        else if(A.equals("Y") && M * 5 <= N) System.out.println("B");
        else if(A.equals("N") && M * 2 <= N) System.out.println("C");
        else if(A.equals("Y") && M * 2 <= N) System.out.println("D");
        else System.out.println("NO PIZZA");
    }
}
