package linkedList;

public class Node {
	
	private String data;
	private Node nextNode;
	
	public Node(String data, Node nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}

	public Node() {
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
