import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] adj = new ArrayList[51];
        for(int i = 1; i <= 50; i++) adj[i] = new ArrayList<>();
        adj[2].add(6); adj[6].add(2);
        adj[1].add(6); adj[6].add(1);
        adj[7].add(6); adj[6].add(7);
        adj[5].add(6); adj[6].add(5);
        adj[4].add(6); adj[6].add(4);
        adj[3].add(6); adj[6].add(3);
        adj[3].add(15); adj[15].add(3);
        adj[3].add(4); adj[4].add(3);
        adj[5].add(4); adj[4].add(5);
        adj[5].add(3); adj[3].add(5);
        adj[13].add(15); adj[15].add(13);
        adj[13].add(12); adj[12].add(13);
        adj[13].add(14); adj[14].add(13);
        adj[12].add(9); adj[9].add(12);
        adj[12].add(11); adj[11].add(12);
        adj[10].add(11); adj[11].add(10);
        adj[10].add(9); adj[9].add(10);
        adj[16].add(17); adj[17].add(16);
        adj[16].add(18); adj[18].add(16);
        adj[18].add(17); adj[17].add(18);
        adj[9].add(8); adj[8].add(9);
        adj[7].add(8); adj[8].add(7);
        String S = br.readLine();
        int X, Y; Queue<Integer> Q;
        while(!S.equals("q")) {
            switch (S) {
                case "i":
                    X = Integer.parseInt(br.readLine());
                    Y = Integer.parseInt(br.readLine());
                    if(!adj[X].contains(Y)) adj[X].add(Y);
                    if(!adj[Y].contains(X)) adj[Y].add(X);
                    break;
                case "d":
                    X = Integer.parseInt(br.readLine());
                    Y = Integer.parseInt(br.readLine());
                    if(!adj[X].contains(Y)) adj[X].remove(Y);
                    if(!adj[Y].contains(X)) adj[Y].remove(X);
                    break;
                case "n":
                    X = Integer.parseInt(br.readLine());
                    System.out.println(adj[X].size());
                    break;
                case "f":
                    X = Integer.parseInt(br.readLine());
                    Y = Integer.parseInt(br.readLine());
                    Q = new LinkedList<>();
                    boolean[] vis = new boolean[51]; int count = 0;
                    vis[X] = true;
                    for(int x: adj[X]) {
                        vis[x] = true;
                        Q.add(x);
                    }
                    while(!Q.isEmpty()) {
                        int cur = Q.poll();
                        for(int x: adj[cur]) {
                            if(!vis[x]) {
                                vis[x] = true;
                                count++;
                            }
                        }
                    }
                    System.out.println(count);
                    break;
                case "s":
                    X = Integer.parseInt(br.readLine());
                    Y = Integer.parseInt(br.readLine());
                    Q = new LinkedList<>();
                    int[] dis = new int[51];
                    Arrays.fill(dis, -1);
                    Q.add(X); dis[X] = 0;
                    while(!Q.isEmpty()) {
                        int cur = Q.poll();
                        for(int x: adj[cur]) {
                            if(dis[x] == -1 ) {
                                dis[x] = dis[cur] + 1;
                                Q.add(x);
                            }
                        }
                    }
                    if(dis[Y] != -1) System.out.println(dis[Y]);
                    else System.out.println("Not connected");
                    break;
                default:
                    break;
            }
        }
    }
}
