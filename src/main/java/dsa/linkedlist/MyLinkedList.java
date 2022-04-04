package dsa.linkedlist;

import java.util.Scanner;

public class MyLinkedList {
	
	public static class LinkedList {
		
		private Node head;
		
		private class Node {
			int data;
			Node next;
			
			public Node() {
				this.data = 0;
				this.next = null;
			}
			
			public Node(int data) {
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
		
		private Node getNthNode(int pos) {

			Node curr = this.head;
			for (int i = 0; i < pos; i++) {
				curr = curr.next;
			}
			return curr;
		}
		
		
		public void add(int element) {
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
			this.size+= 1;
		}
		
		
		public void addAt(int pos, int element) {
			if(pos == size) {
				// add at the end
				add(element);
			} else if(pos == 1){
				// add at start, link new-node next to head and reset head to new-node
				Node newNode = new Node(element);
				newNode.next = this.head;
				this.head = newNode;
				this.size+= 1;
			} else {
				Node prevNode = getNthNode(pos - 1);
				Node newNode = new Node(element);
				newNode.next = prevNode.next;
				prevNode.next = newNode;
				this.size+= 1;
			}
		}
		
		

		public void deleteAtPos(int pos) {
			if(size == 0 || pos < 0 || pos >= size)
				throw new IllegalArgumentException("Cannot delete from empty list!");
			
			if(pos == 0) {
				System.out.println("Delete success for data:"+this.head.data+" @pos:"+pos);
				this.head = head.next;
				this.size = this.size -1;
				return;
			}else if(pos == size -1) {
				Node prevNode = getNthNode(pos -2);
				System.out.println("Delete success for data:"+prevNode.next.data +" @pos:"+pos);
				prevNode.next = null;
			}else {
				Node prevNode = getNthNode(pos -1);
				System.out.println("Delete success for data:"+prevNode.next.data +" @pos:"+pos);
				prevNode.next = prevNode.next.next;
			}
			this.size = this.size -1;
		}
		
		
		// 206: https://leetcode.com/problems/reverse-linked-list/
		public void reverse() {
			
			Node curr = head;
			Node prev = null;
			
			while (curr != null){
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			head = prev;
		}
		
		
		
		public void print() {
			
			if(head == null) {
				System.out.println("\nEmpty list !");
				return;
			}
			
			Node curr = head;
			System.out.print("["+size+"]");
			while(curr.next != null) {
				System.out.print(curr.data + "->");
				curr = curr.next;
			}
			System.out.print(curr.data + "->null");
			System.out.println("\n");
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		for(int i = 0; i < n; i++) {
			list.add(scn.nextInt());
		}
		
		list.print();
		
		list.reverse();
		
		list.print();
		
		scn.close();
		/*
		list.add(10);
		list.add(20);
		list.add(30);
		list.print(list);
		list.addAt(1, 5);
		list.print(list);
		list.addAt(4, 40);
		list.print(list);
		list.addAt(2, 25);
		list.print(list);
		
		list.deleteAtPos(1);
		list.print(list);
		
		list.deleteAtPos(0);
		list.print(list);
		*/
	}
	
}

