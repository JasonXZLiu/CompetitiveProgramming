class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[2];
        
        int[] canA = {-1, -1};
        int[] canB = {-1, -1};
        
        int[] parents = new int[edges.length + 1];
        for (int[] edge : edges) {
            int par = edge[0], child = edge[1];
            if (parents[child] != 0) {         
                // the child already has father
                // the newest link
                canB = new int[]{par, child};
                // old link
                canA = new int[]{parents[child], child};
                edge[1] = -1;
            } else {
                parents[child] = par;
            }
        }
        
        for (int i = 0; i < edges.length; i++) parents[i] = i;
        
        for (int[] edge : edges) {
            if (edge[1] == -1) continue;
            
            if (find(parents, edge[0]) == edge[1]) {
                if (canA[0] == -1) return edge;
                else return canA;
            }
            
            parents[edge[1]] = edge[0];
        }
        
        return canB;
    }
    
    public int find(int[] parents, int p) {
        while (parents[p] != p) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        } 
        return p;
    }
}