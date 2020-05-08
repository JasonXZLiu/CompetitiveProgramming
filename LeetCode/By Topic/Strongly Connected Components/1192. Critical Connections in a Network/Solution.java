class Solution {
    int time;
    int[] timestamp;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (n == 0) return new ArrayList<>();
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for (List<Integer> con : connections) {
            adjList.get(con.get(0)).add(con.get(1));
            adjList.get(con.get(1)).add(con.get(0));
        }
        
        time = 0;
        timestamp = new int[n];
        Arrays.fill(timestamp, -1);
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, adjList, res);
        return res;
    }
    
    public int dfs(int i, int parent, List<List<Integer>> adjList, List<List<Integer>> res) {
        if (timestamp[i] != -1) return timestamp[i];
        timestamp[i] = time;
        time ++;
        
        int minTimestamp = Integer.MAX_VALUE;
        for (int next : adjList.get(i)) {
            if (parent == next) continue;
            int neighbourTimestamp = dfs(next, i, adjList, res);
            minTimestamp = Math.min(minTimestamp, neighbourTimestamp);
        }
        
        if (minTimestamp >= timestamp[i])
            if (parent >= 0)
                res.add(Arrays.asList(parent, i));
        
        return Math.min(minTimestamp, timestamp[i]);
    }
}