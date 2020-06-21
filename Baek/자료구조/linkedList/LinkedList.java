package linkedList;

public class LinkedList {

	private Node head;
	
	public void LinkedList(){
		head = null;
	}
	
	public void insert(String a) {
			
		Node newNode = new Node(a,null);
		
		// 최초 입력이면
		if(head==null) {
			head = newNode;
		}
		// 이미 있으면
		else {
			Node temp = head;
			while(temp.getNextNode()!=null) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(newNode);
		}
	}
	
	// 최초 등장하는 a를 지워줘라
	public void delete(String a) {
		Node prev = head;
		Node temp = head.getNextNode();

	    if(head.getData().equals(a)) { 
	        head = prev.getNextNode(); 
	        prev.setNextNode(null); 
	    }
	    else {
	        while(temp != null) { 
	            if(temp.getData().equals(a)) { 
	                if(temp.getNextNode() == null)
	                    prev.setNextNode(null); 
	                else { 
	                    prev.setNextNode(temp.getNextNode()); 
	                    temp.setNextNode(null); 
	                }
	                return; 
	            }
	            
	            prev = prev.getNextNode(); 
	            temp = temp.getNextNode();
	        }
	    }
	}
	
	// 전체를 출력해라
	public void printAll() {
		
		Node temp = head;
		
		while(true) {
			System.out.println(temp.getData());
			if(temp.getNextNode()!=null) {
				temp = temp.getNextNode();
			}else break;
		}
	}
	
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		list.insert("유");
		list.insert("동");
		list.insert("연");
		
		list.printAll();
		
		list.delete("연");
		
		list.printAll();
		
	}	
}
