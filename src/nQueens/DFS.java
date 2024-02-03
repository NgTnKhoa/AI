package nQueens;

import java.util.List;
import java.util.Stack;

public class DFS {
	public int supportAdd(Node node, int countQueens) {
		List<Integer> newState = node.getState();
		
		while (newState.get(newState.size() - 1) - 1 < 0) {
			newState.remove(newState.size() - 1);
			countQueens--;
		}
		
		int newLastValue = newState.get(newState.size() - 1) - 1;
		newState.remove(newState.size() - 1);
		countQueens--;
		node.setState(newState);
		List<Integer> tempState = node.place(newLastValue);
		
		while (tempState == null) {
			newLastValue--;
			if (newLastValue < 0) {
				return supportAdd(node, countQueens);
			}
			node.setState(newState);
			tempState = node.place(newLastValue);
		}
		
		newState = tempState;
		node.setState(newState);
		countQueens++;
		return countQueens;
	}
	
	public Node DFS(Node node, int goal) {
		Stack<Integer> stack = new Stack<Integer>();
		int randomFirstQueen = (int) (Math.random() * node.getN());
		
		if (goal <= 6) {
			while (randomFirstQueen == 0 || randomFirstQueen == goal - 1) {
				randomFirstQueen = (int) (Math.random() * node.getN());
			}
		}
		
		node.setState(node.place(randomFirstQueen));
		int countQueens = 1;
		
		while (countQueens < goal) {
			for (int i = 0; i < goal; i++) {
				stack.push(i);
			}
			
			boolean added = false;
			while (!stack.isEmpty()) {
				List<Integer> newState = node.place(stack.pop());
				if (newState != null) {
					node.setState(newState);
					added = true;
					break;
				}
			}
			
			if (!added) {
				countQueens = supportAdd(node, countQueens);
				countQueens--;
			}
			
			stack.clear();
			
			countQueens++;
		}
		return node;
	}
}
