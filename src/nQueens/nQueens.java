package nQueens;

public class nQueens {
	private int n;
	private Node goal;

	public nQueens(int n) {
		this.n = n;
		this.goal = new Node(n);
	}
	
	public void BFS() {
		BFS bfs = new BFS();
		this.goal = bfs.BFS(new Node(n), n);
	}
	
	public void DFS() {
		DFS dfs = new DFS();
		this.goal = dfs.DFS(new Node(n), n);
	}
	
	public void printState(Node node) {
		String state = "";
		for (int i = 0; i < node.getState().size(); i++) {
			for (int j = 0; j < node.getState().size(); j++) {
				if (j == node.getState().get(i)) {
					state += "[Q]";
				} else {
					state += "[ ]";
				}
			}
			state += "\n";
		}
		System.out.println(state);
	}
	
	public Node getGoal() {
		return goal;
	}
}
