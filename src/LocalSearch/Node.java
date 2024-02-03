package LocalSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class Node {
	private int n;
	List<Integer> state;
	
	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			Random random = new Random();	
			this.state.add(random.nextInt(n));
		}
	}
	
	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
	}
	
	public int getN() {
		return n;
	}
	
	public List<Integer> getState() {
		return state;
	}
	
	public void setState(List<Integer> state) {
		this.state = state;
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
}
