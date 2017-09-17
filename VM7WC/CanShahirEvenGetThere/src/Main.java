import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        int edges = s.nextInt();
        int a = s.nextInt() - 1;
        int b = s.nextInt() - 1;
        Graph g = new Graph(vertices);
        for(int i = 0; i < edges; i++) {
            g.addEdge(s.nextInt() - 1, s.nextInt()- 1);
        }
        if(g.BFS(a, b)) System.out.println("GO SHAHIR!");
        else System.out.println("NO SHAHIR!");
    }

    static class Graph {
        private int v;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        boolean BFS(int s, int e) {
            boolean visited[] = new boolean[v];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s]=true;
            queue.add(s);
            while (queue.size() != 0) {
                s = queue.poll();
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext())
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        if (n == e) return true;
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            return false;
        }
    }
}
