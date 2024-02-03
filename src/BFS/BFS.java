package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void BFS(Node initial, int goal) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(initial);
		while (queue.size() != 0) {
			Node current = queue.poll();
			
			if (current.getState() == goal) {
				String s = "";
				while (current.getState() != initial.getState()) {
					s = current.getState() + " " + s;
					current = current.getParent();
				}
				s = initial.getState() + " " + s;
				System.out.println(s);
				return;
			}
			
			for (Node neighbor : current.getNeighbors()) {
				if (neighbor.isVisited()) {
					continue;
				} else {
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
	
	
}

