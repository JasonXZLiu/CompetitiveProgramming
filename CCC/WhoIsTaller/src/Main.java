import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start, end;
    static ArrayList<Integer>[] adj;

    public static boolean bfs(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N + 1];
        q.add(s);
        visited[s]++;
        while(!q.isEmpty()) {
            int tmp = q.remove();
            for(int tmp2: adj[tmp]) {
                if(visited[tmp2] != 1) {
                    q.add(tmp2);
                    visited[tmp2]++;
                }
            }
            if(visited[e] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(adj[x] == null) adj[x] = new ArrayList<Integer>();
            if(adj[y] == null) adj[y] = new ArrayList<Integer>();
            adj[x].add(y);
        }
        st = new StringTokenizer(in.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        if(bfs(start, end)) System.out.println("yes");
        else if(bfs(end, start)) System.out.println("no");
        else System.out.println("unknown");
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
