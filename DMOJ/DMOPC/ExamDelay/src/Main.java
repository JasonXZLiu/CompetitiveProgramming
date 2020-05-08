import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine()); int E = Integer.parseInt(br.readLine());
        ArrayList<E>[] adj = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
            double D = Double.parseDouble(st.nextToken()), S = Double.parseDouble(st.nextToken());
            double T = (D / S) * 60;
            adj[X].add(new E(Y, D, S, T));
        }
        double[] dis = new double[V+1]; Arrays.fill(dis, Double.MAX_VALUE);
        int[] num = new int[V+1];
        int[] pre = new int[V+1]; double[] time = new double[V+1];
        PriorityQueue<C> Q = new PriorityQueue<>();
        dis[1] = 0; pre[1] = 0; Q.add(new C(1, 0));
        while(!Q.isEmpty()) {
            C cur = Q.poll();
            for(E x: adj[cur.v]) {
                if(dis[x.v] > dis[cur.v] + x.t) {
                    num[x.v] = num[cur.v] + 1;
                    dis[x.v] = dis[cur.v] + x.t;
                    pre[x.v] = cur.v;
                    time[x.v] = x.t;
                    Q.add(new C(x.v, dis[x.v]));
                } else if(dis[x.v] == dis[cur.v] + x.t) {
                    num[x.v] = num[cur.v] + 1;
                    pre[x.v] = cur.v;
                    time[x.v] = x.t;
                }
            }
        }
        int X = pre[V]; double times = time[V] / 0.75;
        while(X != 0) {
            times += time[X] / 0.75;
            X = pre[X];
        }
        System.out.println(num[V]);
        System.out.println(Math.round(times - dis[V]));
    }

    static class E {
        public int v;
        public double d, s, t;

        E(int v0, double d0, double s0, double t0) {
            v = v0; d = d0; s = s0; t = t0;
        }
    }

    static class C implements Comparable<C> {
        public int v;
        public double w;

        C(int v0, double w0) {v = v0; w = w0;}

        @Override
        public int compareTo(C o) {
            return Double.compare(w, o.w);
        }
    }
}
