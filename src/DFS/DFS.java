package DFS;

import java.util.Stack;

public class DFS {
	public static void DFS(Node initial, int goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(initial);
		initial.setVisited(true);
		while (stack.size() != 0) {
			Node current = stack.peek();
			int currentSize = stack.size();
			
			for (Node neighbor : current.getNeighbors()) {
				if (!neighbor.isVisited()) {
					stack.push(neighbor);
					neighbor.setVisited(true);
					
					if (neighbor.getState() == goal) {
						String s = "";
						while (neighbor.getState() != initial.getState()) {
							s = neighbor.getState() + " " + s;
							neighbor = neighbor.getParent();
						}
						s = initial.getState() + " " + s;
						System.out.println(s);
						return;
					}
					
					break;
				}
			}
			
			if (currentSize == stack.size()) {
				stack.pop();
			}
			
		}
	}
}
