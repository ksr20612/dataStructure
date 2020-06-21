package hashTable;

import java.util.LinkedList;

class Node{
	String key;
	String data;
	
	public Node(String key, String data) {
		this.key = key;
		this.data = data;
	}
}

public class HashTableChain {

	private LinkedList<Node>[] list;
	
	// list의 크기를 결정할 수 없으므로 처음에 만들겠다고 선언할 때 size를 넣어서 만들어주게끔...
	HashTableChain(int size) {
		this.list = new LinkedList[size];
	}
	
	// 넣기
	public void insert(String key, String data) {
		
		int index = hash(key);
		
		Node newNode = new Node(key,data);
		
		LinkedList<Node> nodeList;
		
		// 리스트가 비어있을 경우 값을 넣어주기
		if(list[index]==null) {
			nodeList = new LinkedList<Node>();
			list[index] = nodeList;
		}
		
		list[index].addLast(newNode);
		
	}
	
	// 찾기
	public String search(String key) {
		
		int index = hash(key);
		
		if(list[index]==null) return "존재하는 키가 아닙니다";
		
		for(Node node : list[index]) {
			if(node.key.equals(key)) return node.data;
		}
		
		return "존재하는 키가 아닙니다";
	}
	
	// 삭제하기
	public void remove(String key) {
		
		int index = hash(key);
		int nodeIndex = -1;
		
		if(list[index]==null) System.out.println("존재하는 키가 아닙니다");
		
		for(Node node : list[index]) {
			nodeIndex++;
			if(node.key.equals(key)) {
				list[index].remove(nodeIndex);
			}
		}
	}
	
	// 해싱 함수 ---> 각 철자를 아스키코드로 만들고 더한 후 5로 나누어주는 방식을 채택
	public int hash(String key) {
		
		int index=0;
		
		for(char letter : key.toCharArray()) index+=letter;
		
		return index%5;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashTableChain table = new HashTableChain(5);
		
		table.insert("apple", "사과");
		table.insert("orange", "오렌지");
		table.insert("pineapple", "파인애플");
		
		System.out.println(table.search("apple"));
		System.out.println(table.search("grape"));
		
		table.remove("apple");
		
		System.out.println(table.search("apple"));
	}

}
