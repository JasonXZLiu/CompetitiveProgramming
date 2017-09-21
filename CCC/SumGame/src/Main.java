import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FastReader s = new FastReader();
        int days = s.nextInt();
        int[] a = new int[days];
        a[0] = s.nextInt();
        for (int i = 1; i < days; i++) {
            a[i] = a[i-1] + s.nextInt();
        }
        int tmp = 0;
        int count = 0;
        int total = 0;
        while (count < days) {
            total += s.nextInt();
            if(total == a[count]) {
                if(tmp < total) {
                    tmp = count + 1;
                }
            }
            count++;
        }
        if(tmp != 0) {
            System.out.println(tmp);
        } else {
            System.out.println(0);
        }
    }

    static class FastReader
    {
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
