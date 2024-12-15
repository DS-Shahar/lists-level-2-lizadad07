package list2;

import java.util.Scanner;

import lists.Node;

public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String []args) {

		

		Node <Integer> n1 = new Node<Integer> (1);
		Node <Integer> n2 = new Node<Integer> (1);
		Node <Integer> n3 = new Node<Integer> (5);
		Node <Integer> n4 = new Node<Integer> (5);
		
		Node <Integer> n5 = new Node<Integer> (2);
		Node <Integer> n6 = new Node<Integer> (3);
		Node <Integer> n7 = new Node<Integer> (3);
		Node <Integer> n8 = new Node<Integer> (6);
		
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		Node <Integer> h1 = n1;
		Node <Integer> h2 = n5;
		
		System.out.println(newUpList(h1,h2));

		
	}
	public static Node<Integer> newUpList(Node<Integer> L1,Node<Integer> L2) {
		Node<Integer> p1 = L1;
		Node<Integer> p2 = L2;
		Node<Integer> newH = new Node<>(-1);
		Node<Integer> current = newH;
		boolean flagP1 = true;
		boolean flagP2 = true;
		
			while (flagP1 && flagP2) {
				 if (!p1.hasNext()) {
		            	flagP1=false;
		            }
		            if (!p2.hasNext()) {
		            	flagP2=false;
		            }
		            
				if (p1.getValue()>p2.getValue()) {
					current.setNext(new Node<>(p2.getValue()));
		            current = current.getNext();
		            p2 = p2.getNext();
				}
					
				if (p2.getValue()>p1.getValue()) {
					current.setNext(new Node<>(p1.getValue()));
		            current = current.getNext();
					p1 = p1.getNext();
				}
				if (p2.getValue().equals(p1.getValue())) {
					current.setNext(new Node<>(p1.getValue()));
		            current = current.getNext();
		            current.setNext(new Node<>(p1.getValue()));
		            current = current.getNext();
					p2 = p2.getNext();
					p1 = p1.getNext();
				}
		            
		           
				}
				
				if (!flagP1) {
					if (p1.getValue()<p2.getValue()) {
						current.setNext(new Node<>(p1.getValue()));
			            current = current.getNext();
			            while (p2!=null) {
			            	current.setNext(new Node<>(p2.getValue()));
				            current = current.getNext();
				            p2 = p2.getNext();
			            }
					}
					
					if (p1.getValue()>p2.getValue()) {
			            while (p2!=null) {
			            	if (p1.getValue()>p2.getValue()) {
			            	current.setNext(new Node<>(p2.getValue()));
				            current = current.getNext();
				            p2 = p2.getNext();
			            	}
			            	if (p1.getValue()==p2.getValue()) {
			            		current.setNext(new Node<>(p2.getValue()));
					            current = current.getNext();
					            current.setNext(new Node<>(p2.getValue()));
					            current = current.getNext();
					            p2 = p2.getNext();
			            	}
			            	if (p1.getValue()<p2.getValue()) {
			            }
					}
						
				}
				
				if (!flagP2) {
					
				}
				
			
			return newH.getNext();
				
		}
		

}
