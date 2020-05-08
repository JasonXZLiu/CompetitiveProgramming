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
        int N = Integer.parseInt(br.readLine());
        City[] cities = new City[N+1];
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            cities[i] = new City(x, y);
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int tmp = (cities[i].x-cities[j].x)*(cities[i].x-cities[j].x)+(cities[i].y-cities[j].y)*(cities[i].y-cities[j].y);
                adj[i].add(new E(j, tmp)); adj[j].add(new E(i, tmp));
            }
        }
        int X = Integer.parseInt(br.readLine());
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<E> Q = new PriorityQueue<>();
        Q.add(new E(X, 0)); dis[X] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if(dis[e.v] > dis[cur.v] + e.w) {
                    dis[e.v] = dis[cur.v] + e.w;
                    Q.add(new E(e.v, dis[e.v]));
                }
            }
        }
        Arrays.sort(dis);
        for(int v = 0; v < N; v++) {
            System.out.print(dis[v] + " ");
        }
        System.out.println();
        int query = Integer.parseInt(br.readLine());
        for(int i = 0; i < query; i++) {
            int count = 0;
            int q = Integer.parseInt(br.readLine());
            while(dis[count] <= q) {count++;}
            System.out.println(count);
        }
    }

    static class City {
        public int x, y;

        City(int x0, int y0) {x = x0; y = y0;}
    }

    static class E implements Comparable<E> {
        public int v, w;

        E(int v0, int w0) {v = v0; w = w0;}

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }
 }
