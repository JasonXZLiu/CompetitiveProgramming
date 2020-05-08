class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());

        for (int[] prereq : prerequisites) {
            int req = prereq[1];
            int course = prereq[0];

            adjList.get(req).add(course);
            indegrees[course]++;
        }

        Stack<Integer> stack = new Stack<>();
        int[] courses = new int[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0)
                stack.push(i);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            courses[count] = node;
            count ++;

            for (int next : adjList.get(node)) {
                indegrees[next]--;

                if (indegrees[next] == 0)
                    stack.push(next);
            }
        }

        return count == numCourses ? courses : new int[0];
    }
}