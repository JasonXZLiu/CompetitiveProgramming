import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FastReader s = new FastReader();
        ArrayList<Long> front = new ArrayList<>();
        ArrayList<Long> end = new ArrayList<>();
        int times = s.nextInt();
        for (int i = 0; i < times; i++) {
            String a = s.next();
            Long l = s.nextLong();
            if(a.equals("F")) {
                front.add(l);
            } else if (a.equals("E")){
                end.add(l);
            } else if (a.equals("R")){
                if(!front.contains(l)) {
                    end.remove(l);
                } else {
                    front.remove(l);
                }
            }
        }
        for (int i = front.size() - 1; i >= 0; i--) {
            System.out.println(front.get(i));
        }
        for (int i = 0; i < end.size(); i++) {
            System.out.println(end.get(i));
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