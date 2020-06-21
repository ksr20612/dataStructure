package tree;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
	}
}

public class Tree {
	
	Node root;
	
	// 최초 생성 시
	public Tree(){
		root = null;
	}
	
	// 저장하기
	public void insert(int newData) {
		
		Node newNode = new Node(newData);
		
		if(root==null) {	// 최초값이면
			root = newNode;
		}
		else {	// 처음이 아니면
			
			// 위치 확인 필요
			Node temp = root;
			
			while(temp!=null) {
				if(newData>temp.data) {
					if(temp.right==null) {
						temp.right = newNode;
						break;
					}
					else temp = temp.right;
				} else if(newData<temp.data) {
					if(temp.left==null) {
						temp.left = newNode;
						break;
					}
					else temp = temp.left;
				}
			}
		}
	}
	
	// 해당 data가 붙을 parentNode를 인출하자
	private Node searchParent(int newData) {
		Node temp = root;
		
		while(temp!=null) {
			if(newData>temp.data) {
				if(temp.right.data==newData) break;
				else temp = temp.right;
			}else {
				if(temp.left.data==newData) break;
				else temp = temp.left;
			}
		}
		return temp;
		
	}
	
	// 존재하냐?
	private boolean isThere(int newData) {
		Node temp = root;
		
		while(temp!=null) {
			
			if(temp.data==newData) {
				return true;
			}
			
			if(newData>temp.data) {
				if(temp.right==null) break;
				else temp = temp.right;
			}else {
				if(temp.left==null) break;
				else temp = temp.left;
			}
		}
		
		return false;
	}
	
	public void remove(int newData) {
		
		Node temp = root;
		
		// 1. 존재하냐?
		boolean isThere = false;
		while(temp!=null) {
			
			if(temp.data==newData) {
				isThere = true;
				break;
			}
			
			if(newData>temp.data) {
				if(temp.right==null) break;
				else temp = temp.right;
			}else {
				if(temp.left==null) break;
				else temp = temp.left;
			}
		}

		// 2. 존재하는 경우에만 삭제 실행 
		if(isThere) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree tree = new Tree();
		tree.insert(3);
		tree.insert(2);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		
		tree.remove(2); // terminal node 삭제
		tree.remove(5); // childNode 1개인 parentNode 삭제
		tree.remove(6); // childNode 2개인 parentNode 삭제
	}

}
