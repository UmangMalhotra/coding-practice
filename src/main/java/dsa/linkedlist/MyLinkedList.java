package dsa.linkedlist;

public class MyLinkedList {

	public static class LinkedList {
		
		private Node head;
		
		private class Node {
			String data;
			Node next;
			
			public Node(String data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return "Node [data=" + data + ", next=" + next + "]";
			}
		}
		
		
		private int size;
		
		public int getSize() {
			return this.size;
		}
		
		public void add(String element) {
			Node newNode = new Node(element);
			
			if(this.head == null) {
				this.head = newNode;
			}else {
				Node curr = this.head;
				while(curr.next != null) {
					curr = curr.next;
				}
				curr.next = newNode;
			}
			this.size = this.size + 1;
		}
		
		
		public void print() {
			
			if(this.head == null) {
				System.out.println("\nEmpty list !");
				return;
			}
			
			Node curr = this.head;
			System.out.println();
			while(curr.next != null) {
				System.out.print(curr.data + "->");
				curr = curr.next;
			}
			System.out.print(curr.data + "-> null");
			System.out.println("\n");
		}
		
		private Node getNthNode(int pos) {

			Node curr = this.head;
			for (int i = 0; i < pos; i++) {
				curr = curr.next;
			}
			return curr;
		}
		
		public void deleteAtPos(int pos) {
			
			if(size == 0 || pos < 0 || pos >= size)
				throw new IllegalArgumentException("Cannot delete from empty list!");
			
			if(pos == 0) {
				System.out.println("Delete success for data:"+this.head.data);
				this.head = head.next;
				return;
			}else if(pos == size -1) {
				Node prevNode = getNthNode(pos -2);
				prevNode.next = null;
			}else {
				Node prevNode = getNthNode(pos -1);
				prevNode.next = prevNode.next.next;
			}
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		list.print();
		
		list.deleteAtPos(1);
		list.print();
		
	}
	
}

