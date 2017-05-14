import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 5/6/2017.
 */
public class FastReader {
    BufferedReader br;
    StringTokenizer st;
    File file = new File("C:\\Users\\jason_001\\IdeaProjects\\Comp3\\TLE'16Contest8P4-DeliveryService\\test.txt");
    FileInputStream fr = new FileInputStream(file);

    public FastReader() throws FileNotFoundException {
        br = new BufferedReader(new
                InputStreamReader(fr));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
