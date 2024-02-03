package BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
	private int state;
	private boolean visited;
	private List<Node> neighbors;
	private Node parent;
	
	public Node(int state) {
		this.state = state;
		this.neighbors = new ArrayList<Node>();
		this.parent = null;
	}
	
	public int getState() {
		return state;
	}
	
	public void addNeighbors(Node neighbor) {
		this.neighbors.add(neighbor);
		neighbor.setParent(this);
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public static void main(String[] args) {
//		Node n1 = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
//		Node n5 = new Node(5);
//		Node n6 = new Node(6);
//		Node n7 = new Node(7);
//		Node n8 = new Node(8);
//		Node n9 = new Node(9);
//		Node n10 = new Node(10);
//		
//		n1.addNeighbors(n2);
//		n1.addNeighbors(n3);
//		n1.addNeighbors(n4);
//		
//		n2.addNeighbors(n5);
//		n2.addNeighbors(n6);
//		
//		n3.addNeighbors(n7);
//		
//		n4.addNeighbors(n8);
//		n4.addNeighbors(n9);
//		
//		n9.addNeighbors(n10);
		
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node40 =new Node(40);
		Node node50 =new Node(50);
		Node node60 =new Node(60);
		Node node70 =new Node(70);
 
		node10.addNeighbors(node30);
		node20.addNeighbors(node10);
		node20.addNeighbors(node30);
		node20.addNeighbors(node60);
		node20.addNeighbors(node50);
		node30.addNeighbors(node60);
		node40.addNeighbors(node10);
		node40.addNeighbors(node20);
		node50.addNeighbors(node70);
		node60.addNeighbors(node70);
 
		BFS bfs = new BFS(); 
		bfs.BFS(node40, 70);
	}
}
