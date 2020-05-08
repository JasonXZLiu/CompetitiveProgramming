import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] adj;
    static int len, root;

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N + 1];
        int[] dis = new int[N + 1];
        q.add(start); visited[start]++; dis[start] = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            if (dis[cur] > len) {
                len = Math.max(len, dis[cur]);
                root = cur;
            }
            for (int v : adj[cur]) {
                if (visited[v] != 1) {
                    q.add(v);
                    visited[v]++;
                    dis[v] = dis[cur] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        FastReader in = new FastReader();
        N = in.nextInt();
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i < N; i++) {
            int tmp = in.nextInt();
            int tmp2 = in.nextInt();
            adj[tmp].add(tmp2);
            adj[tmp2].add(tmp);
        }
        len = 0; BFS(1);
        len = 0; BFS(root);
        System.out.println(len);
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