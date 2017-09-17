import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        Graph g = new Graph(50);
        g.addEdge(2, 6);
        g.addEdge(1, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 10);
        g.addEdge(10, 11);
        g.addEdge(11, 12);
        g.addEdge(9, 12);
        g.addEdge(12, 13);
        g.addEdge(13, 14);
        g.addEdge(13, 15);
        g.addEdge(15, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(4, 6);
        g.addEdge(3, 5);
        g.addEdge(18, 17);
        g.addEdge(16, 17);
        g.addEdge(18, 16);
        boolean b = true;
        while(b) {
            String tmp1 = s.next();
            switch (tmp1) {
                case "n": System.out.println(g.length(s.nextInt())); break;
                case "i": g.addEdge(s.nextInt(), s.nextInt()); break;
                case "d": g.delEdge(s.nextInt(), s.nextInt()); break;
                case "f": System.out.println(g.lenOfLength(s.nextInt())); break;
                case "s": {
                    int tmp = g.BFS(s.nextInt(), s.nextInt());
                    if(tmp != 0) System.out.println(tmp);
                    else System.out.println("Not Connected");
                    break;
                }
                default: b=false; break;
            }
        }
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

        void delEdge(int v, int w) {
            adj[v].remove(w);
        }

        int length(int v) {return adj[v].size();}

        int lenOfLength(int v) {
            TreeSet<Integer> t = new TreeSet<Integer>();
            for(int i = 0; i < adj[v].size(); i++) {
                int tmp = adj[v].get(i);
                for(int j = 0; j < adj[tmp].size(); j++) {
                    t.add(adj[tmp].get(j));
                }
            }
            return t.size();
        }

        int BFS(int s, int e) {
            boolean visited[] = new boolean[v];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s]=true;
            queue.add(s);
            int count = 0;
            while (queue.size() != 0) {
                s = queue.poll();
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext())
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        count++;
                        if (n == e) return count;
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            return 0;
        }
    }
}
