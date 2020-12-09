package Doyeon.p_20201213;

public class Node implements Comparable<Node> {
	private int index;
	private int cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}
