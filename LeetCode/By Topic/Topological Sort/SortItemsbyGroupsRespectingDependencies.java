class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> adjItems = new HashMap<>();
        Map<Integer, Integer> itemIndegrees = new HashMap<>();

        Map<Integer, Set<Integer>> adjGroups = new HashMap<>();
        Map<Integer, Integer> groupIndegrees = new HashMap<>();

        for (int i = 0; i < n; i++)
            adjItems.putIfAbsent(i, new HashSet<>());

        for (int g : group)
            adjGroups.putIfAbsent(g, new HashSet<>());

        for (int i=0;i<beforeItems.size();i++) {
            List<Integer> list = beforeItems.get(i);
            if(list.size()!=0) {
                for (int val : list) {
                    adjItems.get(val).add(i);
                    itemIndegrees.put(i,itemIndegrees.getOrDefault(i,0)+1);
                    
                    int g1 = group[val];
                    int g2 = group[i];
                    if (g1 != g2 && adjGroups.get(g1).add(g2)) {
                        groupIndegrees.put(g2,groupIndegrees.getOrDefault(g2,0)+1);
                    }
                }
            }
        }

        List<Integer> itemOrdering = topSort(adjItems, itemIndegrees, n);
        List<Integer> groupOrdering = topSort(adjGroups, groupIndegrees, adjGroups.size());

        if (itemOrdering.size() == 0 || groupOrdering.size() == 0)
            return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int item : itemOrdering) {
            int g = group[item];
            map.putIfAbsent(g, new ArrayList<>());
            map.get(g).add(item);
        }

        int[] res = new int[n];
        int i = 0;

        for (int g : groupOrdering) {
            for (int item : map.get(g)) {
                res[i++] = item;
            }
        }

        return res;
    }

    private List<Integer> topSort(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> inDegree, int count) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i : graph.keySet())
            if (inDegree.getOrDefault(i, 0) == 0)
                queue.add(i);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count --;
            res.add(cur);
            
            for (int next : graph.get(cur)) {
                int val = inDegree.get(next);
                inDegree.put(next, val - 1);
                
                if (inDegree.get(next) == 0)
                    queue.add(next);
            }
        }
        
        return count == 0 ? res : new ArrayList<>();
    }
}