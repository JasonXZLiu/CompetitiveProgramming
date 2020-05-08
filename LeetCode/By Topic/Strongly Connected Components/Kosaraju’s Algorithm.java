class Solution {
	
	public List<List<Integer>> findSCC(int N, List<List<Integer>> adjList) {
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[N];
		for (int i = 0; i < N; i ++)
			if (!vis[i])
				fillOrder(i, adjList, vis, stack);

		adjList = reverseGraph(adjList);

		List<List<Integer>> forest = new ArrayList<>();
		boolean[] vis2 = new boolean[N];

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			if (!vis2[cur]) {
				List<Integer> scc = new ArrayList<>();
				dfs(cur, adjList, vis, scc);
				scc.add();
			}
		}

		return forest;
	}

	public List<List<Integer>> reverseGraph(List<List<Integer>> adjList) {
		List<List<Integer>> reverseList = new ArrayList<>();

		for (int i = 0; i < adjList.size(); i++) 
			reverseList.add(new ArrayList<>());

		for (int i = 0; i < adjList.size(); i++)
			for (int j : adjList.get(i))
				reverseList.get(j).add(i);

		return reverseList;
	}

	public void fillOrder(int node, List<List<Integer>> adjList, boolean[] vis, Stack<Integer> stack) {
		vis[node] = true;

		for (int next : adjList.get(node)) {
			if (!vis[next]) {
				fillOrder(node, adjList, vis, stack);
			}
		}

		stack.push(node);
	}

	public void dfs(int node, List<List<Integer>> adjList, boolean[] vis, List<Integer> scc) {
		vis[node] = true;
		scc.add(node);

		for (int next : adjList.get(node)) {
			if (!vis[next]) {
				dfs(next, adjList, vis, scc);
			}
		}
	}
}