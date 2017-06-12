import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        PrintWriter w = new PrintWriter("C:/Users/jason_001/Documents/GitHub/ComputerContest/Algorithms/OddNumber/src/test.txt");
        w.println(1000000);
        for (long i = 0; i < 1000000; i++) {
            w.println(1);
        }
        long ans = 0;
        FastReader s = new FastReader();
        long times = s.nextInt();
        // for loop for up to number of numbers
        for (long i = 0; i < times; i++) {
            ans = ans ^ s.nextInt();
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}

