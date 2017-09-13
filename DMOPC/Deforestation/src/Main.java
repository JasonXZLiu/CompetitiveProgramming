import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int numTrees = s.nextInt();
        int[] mass = new int[numTrees];
        for(int i = 0; i < numTrees; i ++){mass[i] = s.nextInt();}
        for(int i = 1; i < numTrees; i ++){mass[i] = mass[i] + mass[i-1];}
        int cases = s.nextInt();
        for(int i = 0; i < cases; i ++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (a != 0) {
                System.out.println(mass[b] - mass[a - 1]);

            } else {
                System.out.println(mass[b]);
            }
        }
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