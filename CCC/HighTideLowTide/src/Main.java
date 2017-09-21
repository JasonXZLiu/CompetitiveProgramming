import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FastReader s = new FastReader();
        int tides = s.nextInt();
        int[] a = new int[tides];
        for (int i = 0; i < tides; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        if(tides % 2 == 0) {
            int middle = tides / 2;
            for(int i = middle - 1; i >= 0; i--) {
                System.out.print(a[i] + " ");
                System.out.print(a[tides - 1 - i] + " ");
            }
        } else {
            int middle = (tides-1) / 2;
            System.out.print(a[middle] + " ");
            for(int i = middle - 1; i >= 0; i--) {
                System.out.print(a[tides - 1 - i] + " ");
                System.out.print(a[i] + " ");
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
