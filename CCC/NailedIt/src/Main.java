import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FastReader in = new FastReader();
        long numWoods = in.nextLong();
        long[] planks = new long[2001];
        long max = 0, secondMax = 0;
        for (int i = 0; i < numWoods; i++) {
            int a = in.nextInt();
            planks[a]++;
            if(max <= Math.max(a, max)) {
                secondMax = max;
                max = Math.max(a, max);
            }
        }
        if(secondMax == 0) secondMax = max;
        long high = max + secondMax;
        long[] blah = new long[(int) high + 2];
        for(int i = 1; i <= high + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // need if statement here
                if(i - j <= max) {
                    if (planks[j] != 0 && planks[i - j] != 0) {
                        if (i % 2 == 0 && i / 2 == j) {
                            blah[i] += Math.floor(planks[j] / 2);
                        } else {
                            blah[i] += Math.min(planks[j], planks[i - j]);
                        }
                    }
                }
            }
        }
        long tmpMax = 0, cnt = 1;
//        for(int i = 1; i <= high + 1; i++) System.out.println(i + " " + blah[i]);
        for(int i = 1; i <= high + 1; i++) {
            long tmp2 = blah[i];
            if(blah[i] != 0) {
                if (tmpMax < tmp2) {
                    tmpMax = tmp2;
                    cnt = 1;
                } else {
                    if(!(tmp2 < tmpMax)) cnt++;
                }
            }
        }
        System.out.println(tmpMax + " " + cnt);
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
