import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, H;
    static int[][] graph;

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N*N];
        int x = 0;
        int y = 0;
        q.add(0);
        while(!q.isEmpty()) {
            int tmp = q.remove();
            y = tmp % N;
            x = (tmp - (y)) / N;
            if(y+1 < N) {
                if((Math.abs(graph[x][y] - graph[x][y+1]) <= H) && visited[x * N + y + 1] != 1) {
                    visited[x * N + y + 1] = 1;
                    q.add(x * N + y + 1);
                }
            }
            if(x + 1 < N) {
                if ((Math.abs(graph[x][y] - graph[x + 1][y]) <= H) && visited[(x + 1) * N + y] != 1) {
                    visited[(x + 1) * N + y] = 1;
                    q.add((x + 1) * N + y);
                }
            }
        }
        if(visited[N*N - 1] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        H = in.nextInt();
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        if(bfs()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
