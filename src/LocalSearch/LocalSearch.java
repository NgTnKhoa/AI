package LocalSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {
	public int checkHorizontal(Node node) {
		int result = 0;

		for (int i = 0; i < node.getState().size(); i++) {
			for (int j = 0; j < node.getState().size(); j++) {
				if (j == i) {
					continue;
				}

				if (node.getState().get(i) == node.getState().get(j)) {
					result++;
				}
			}
		}

		return result;
	}

	public int checkDiagonal(Node node) {
		int result = 0;

		for (int i = 0; i < node.getState().size(); i++) {
			int currentValueChecker = node.getState().get(i);

			for (int j = 1; j < node.getState().size(); j++) {
				if (i + j < node.getState().size()) {
					if (node.getState().get(i + j) == currentValueChecker + j) {
						result++;
					}

					if (node.getState().get(i + j) == currentValueChecker - j) {
						result++;
					}
				}

				if (i - j >= 0) {
					if (node.getState().get(i - j) == currentValueChecker + j) {
						result++;
					}

					if (node.getState().get(i - j) == currentValueChecker - j) {
						result++;
					}
				}
			}
		}

		return result;
	}

	public int heuristic(Node node) {
		return checkDiagonal(node) + checkHorizontal(node);
	}

	public int tryMovingOneQueen(Node node, int x, int y) {
		List<Integer> newState = node.getState();
		newState.set(y, x);
		node.setState(newState);
		return heuristic(node);
	}

	public SortedMap<Integer, Node> generateNeighbours(Node node, int checker) {
		SortedMap<Integer, Node> result = new TreeMap<Integer, Node>();

		for (int i = 0; i < node.getN(); i++) {
			//clone old state
			List<Integer> neighborState = new ArrayList<Integer>();
			for (int j = 0; j < node.getN(); j++) {
				neighborState.add(node.getState().get(j));
			}
			
			Node neighbor = new Node(node.getN(), neighborState);
					
			if (i == node.getState().get(checker)) {
				continue;
			} else {
				result.put(tryMovingOneQueen(neighbor, i, checker), neighbor);
			}
		}
		
		return result;
	}

	public void run() {
		Node initial = new Node(8);
		
		if (heuristic(initial) == 0) {
			System.out.println(initial.state);
			return;
		}
		
		System.out.println("Initial state is: " + initial.state + " " + heuristic(initial));
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node, 0);
		int bestHeuristic = neighbours.firstKey();
		int checker = 1;

		for (int heuristicNeighbor : neighbours.keySet()) {			
			if (bestHeuristic > heuristicNeighbor) {
				bestHeuristic = heuristicNeighbor;
			}
		}
		
		while (true) {
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node, checker);
			bestHeuristic = neighbours.firstKey();
			
			for (int heuristicNeighbor : neighbours.keySet()) {			
				if (bestHeuristic > heuristicNeighbor) {
					bestHeuristic = heuristicNeighbor;
				}
			}
			
			checker++;
			if (checker >= node.getN()) {
				break;
			}
		}
		
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else {
			System.out.println("Cannot find goal state! Best state is: " + node.state + " " + heuristic(node));
		}
	}

	public static void main(String[] args) {
		LocalSearch ls = new LocalSearch();
		long a = System.currentTimeMillis();
		ls.run();
		long b = System.currentTimeMillis();
		System.out.println(b - a + " ms");
	}
}
