class Solution {
	
	// Kahn's algorithm
	public List<Integer> topSort(List<List<Integer>> adjList, int[] indegrees, int count) {
		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < count; i++)
			if (indegrees[i] == 0)
				queue.add(i);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			count --;
			res.add(cur);

			for (int next : adjList.get(cur)) {
				indegrees[next] --;

				if (indegrees[next] == 0)
					queues.add(next);
			}
		}

		return count == 0 ? res : new ArrayList<>();
	}
}