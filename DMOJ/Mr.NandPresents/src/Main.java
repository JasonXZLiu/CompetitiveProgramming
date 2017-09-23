import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FastReader s = new FastReader();
        LinkedList l = new LinkedList();
        int times = s.nextInt();
        for (int i = 0; i < times; i++) {
            String a = s.next();
            if(a.equals("F")) {
                l.addFirst(s.nextLong());
            } else if (a.equals("E")){
                l.addLast(s.nextLong());
            } else if (a.equals("R")){
                l.remove(s.nextLong());
            }
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
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
