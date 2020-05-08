class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        
        for (int[] prereq : prerequisites) {
            int req = prereq[0];
            int course = prereq[1];
            
            adjList.get(req).add(course);
            indegrees[course]++;
        }
        
        int visited = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0)
                stack.push(i);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited ++;
            
            for (int next : adjList.get(node)) {
                indegrees[next]--;

                if (indegrees[next] == 0)
                    stack.push(next);
            }
        }
        
        return visited == numCourses;
    }
}