class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return new int[2];
        
        DSU dsu = new DSU(edges.length);
        int[] ans = new int[2];
        
        for (int[] edge : edges) {
            int p = edge[0] - 1, q = edge[1] - 1;
            if (dsu.find(p) != dsu.find(q)) dsu.union(p, q);
            else ans = edge;
        }
        
        return ans;
    }
    
    class DSU {
        int[] parents;
        
        public DSU(int N) {
            this.parents = new int[N];
            for (int i = 0; i < N; i++) parents[i] = i;
        }
        
        public int find(int p) {
            if (parents[p] != p) return find(parents[p]);
            return p;
        }
        
        public void union(int p, int q) {
            parents[find(p)] = find(q);
        }
    }
}