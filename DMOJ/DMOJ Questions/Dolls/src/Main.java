import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FastReader in = new FastReader();
        int N = in.nextInt();
        int[] nums = new int[101];
        for(int i =0; i < N; i++) {
            int A = in.nextInt();
            nums[A]++;
        }
        int min = -1;
        int max = -1;
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for(int i = 0; i < 101; i++) {
            if(nums[i] != 0){
                if(nums[i] < MIN){
                    MIN = nums[i];
                    min = i;
                }
                else if(nums[i] == MIN) min = Math.min(min, i);
                if(nums[i] > MAX){
                    MAX = nums[i];
                    max = i;
                }
                else if(nums[i] == MAX) max = Math.max(max, i);
            }
        }
        System.out.println(Math.abs(max - min));
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
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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
