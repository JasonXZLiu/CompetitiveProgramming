class Solution {
	int time = 0;
	
	public List<List<Integer>> findSCC(int N, List<List<Integer>> adjList) {
		int[] low = new int[N], disc = new int[N];
		Arrays.fill(disc, -1);

		List<List<Integer>> forest = new ArrayList<>();
		for (int i = 0; i < N; i++)
			forest.add(new ArrayList<>());

		for (int i = 0; i < N; i++)
			if (disc[i] == -1)
				dfs(i, -1, low, disc, adjList, forest);

		return forest;
	}

	public void dfs(int node, int par, int[] low, int[] disc, List<List<Integer>> adjList, Stack<Integer> stack, List<List<Integer>> forest) {
		time ++;
		disc[node] = time;
		low[node] = time;
		stack.add(node);

		for (int next : adjList.get(node)) {
			if (par == next) continue;

			if (disc[next] == -1) {
				dfs(next, node, low, disc, adjList, forest);
				low[node] = Math.min(low[node], low[next]);
			} else {
				low[node] = Math.min(low[node], disc[next]);
			}
		}

		List<Integer> scc = new ArrayList<>();
		while (!stack.isEmpty()) {
			scc.add(stack.pop());
		}
	}
}