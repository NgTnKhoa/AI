package nQueens;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int n; 
	private List<Integer> state;
	
	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<Integer>();
	}
	
	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
	}
	
	public int getN() {
		return n;
	}
	
	public void setState(List<Integer> state) {
		this.state = state;
	}
	
	public List<Integer> getState() {
		return state;
	}
	
	public boolean isValid(List<Integer> state) {
		boolean result = true;
		
		if (state.size() == 1) {
			return true;
		} else {
			int lastQueen = state.get(state.size() - 1);
			
			for (int i = 0; i < state.size() - 1; i++) {
				int currentQueen = 0;
				if (state.get(i) == null) {
					continue;
				} else {
					currentQueen = state.get(i);
				}
				
				//check horizontal
				if (lastQueen == currentQueen) {
					return false;
				}
				
				//check diagonal
				int k = currentQueen + 1;
				for (int j = i + 1; j < state.size(); j++) {
					
					if (j == state.size() - 1 && k == lastQueen) {
						result = false;
						break;
					}
					
					k++;
				}
				
				k = currentQueen - 1;
				for (int j = i + 1; j < state.size(); j++) {
					
					if (j == state.size() - 1 && k == lastQueen) {
						result = false;
						break;
					}
					
					k--;
				}
			}
		}
		return result;
	}
	
	public List<Integer> place(int x) {
		List<Integer> result = new ArrayList<Integer>(this.state);
		result.add(x);
		return isValid(result) ? result : null;
	}

	public static void main(String[] args) {
		nQueens q = new nQueens(8);
		
		System.out.println("BFS");
		q.BFS();
		q.printState(q.getGoal());
		
		System.out.println("DFS");
		q.DFS();
		q.printState(q.getGoal());
	}
}
