import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;

    public static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N + 1];
        q.add(start);
        int pre = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            pre = q.remove();
            if(pre != N) {
                for (int i = 0; i < graph[pre].size(); i++) {
                    if(graph[pre].get(i) != N && visited[i] != 1) {
                        visited[i] = 1;
                        q.add(graph[pre].get(i));
                        cnt++;
                    }
                }
            }
        }
        int[] value = new int[2];
        value[0] = cnt;
        value[1] = pre;
        return value;
    }

    public static void main(String[] args) {
	// write your code here
        FastReader in = new FastReader();
        N = in.nextInt();
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i < N+1; i++) graph[i] = new ArrayList<>();
        for(int i = 1; i < N; i++) {
            int tmp = in.nextInt();
            int tmp2 = in.nextInt();
            graph[tmp].add(tmp2);
            graph[tmp2].add(tmp);
        }
        int root = 1;
        int cnt = 0;
        int[] ans = new int[2];
        while(cnt < 2) {
            ans = bfs(root);
            root = ans[1];
            cnt++;
        }
        System.out.println(ans[0]);
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
