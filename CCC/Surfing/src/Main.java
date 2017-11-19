import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int cnt = 0;
        ArrayList<Integer>[] arr = new ArrayList[a];
        for (int i = 0; i < a; i++) {
            arr[i] = new ArrayList<>();
        }
        while(cnt < a) {
            String blah = br.readLine();
            if(blah.contains("</HTML>")) {
                cnt++;
            } else if (blah.contains("<A HREF=")) {
                blah.split("http://");
            }
        }
        String tmp = br.readLine();
        while(!tmp.equals("The End")) {

        }
    }
}
