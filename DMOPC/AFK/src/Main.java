import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FastReader in = new FastReader();
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int C = in.nextInt();
            int R = in.nextInt();
            int[][] a = new int[R][C];
            int[][] vis = new int[R][C];
            Queue<Integer> qR = new LinkedList<>();
            Queue<Integer> qC = new LinkedList<>();
            boolean b = true;
            int startR = 0, startC = 0, endR = 0, endC = 0;
            for(int j = 0; j < R; j++) {
                String s = in.nextLine();
                for(int k = 0; k < C; k++) {
                    String s2 = s.substring(k, k+1);
                    if(s2.equals("X")) {
                        a[j][k] = 1;
                    } else if (s2.equals("C")) {
                        startR = j;
                        startC = k;
                        qR.add(startR);
                        qC.add(startC);
                    } else if (s2.equals("W")) {
                        a[j][k] = 2;
                        endR = j;
                        endC = k;
                    }
                }
            }
            vis[startR][startC] = 0;
            while(b && vis[startR][startC] < 60 && qC.size() > 0) {
                startC = qC.remove();
                startR = qR.remove();
                if(startR - 1 >= 0) {
                    if(a[startR-1][startC] == 0 || a[startR-1][startC] == 2) {
                        if(vis[startR-1][startC] == 0) {
                            vis[startR-1][startC] = vis[startR][startC] + 1;
                            qC.add(startC);
                            qR.add(startR-1);
                            if(a[startR-1][startC] == 2) {
                                b = false;
                            }
                        }
                    }
                }
                if(startR + 1 < R) {
                    if(a[startR+1][startC] == 0 || a[startR+1][startC] == 2) {
                        if(vis[startR+1][startC] == 0) {
                            vis[startR+1][startC] = vis[startR][startC] + 1;
                            qC.add(startC);
                            qR.add(startR+1);
                            if(a[startR+1][startC] == 2) {
                                b = false;
                            }
                        }
                    }
                }
                if(startC + 1 < C) {
                    if(a[startR][startC+1] == 0 || a[startR][startC+1] == 2) {
                        if(vis[startR][startC+1] == 0) {
                            vis[startR][startC+1] = vis[startR][startC] + 1;
                            qC.add(startC+1);
                            qR.add(startR);
                            if(a[startR][startC+1] == 2) {
                                b = false;
                            }
                        }
                    }
                }
                if(startC - 1 >= 0) {
                    if(a[startR][startC-1] == 0 || a[startR][startC-1] == 2) {
                        if(vis[startR][startC-1] == 0) {
                            vis[startR][startC-1] = vis[startR][startC] + 1;
                            qC.add(startC-1);
                            qR.add(startR);
                            if(a[startR][startC-1] == 2) {
                                b = false;
                            }
                        }
                    }
                }
            }
            if(vis[endR][endC] < 60) {
                System.out.println(vis[endR][endC]);
            } else {
                System.out.println("#notworth");
            }
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
