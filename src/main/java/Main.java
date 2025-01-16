


import java.util.Scanner;


public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String []args) {

		

		Node <Integer> n1 = new Node<Integer> (1);
		Node <Integer> n2 = new Node<Integer> (1);
		Node <Integer> n3 = new Node<Integer> (5);
		Node <Integer> n4 = new Node<Integer> (7);
		
		Node <Integer> n5 = new Node<Integer> (2);
		Node <Integer> n6 = new Node<Integer> (3);
		Node <Integer> n7 = new Node<Integer> (5);
		Node <Integer> n8 = new Node<Integer> (8);
		
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		Node <Integer> h1 = n1;
		Node <Integer> h2 = n5;
//---- seif1
//		System.out.println(newUpList(h1,h2));
//---- seif2
		Node <Integer> n22 = new Node<Integer> (6);
		Node <Integer> n23 = new Node<Integer> (2);
		Node <Integer> n24 = new Node<Integer> (6);
		Node <Integer> n25 = new Node<Integer> (6);
		Node <Integer> n26 = new Node<Integer> (1);
		
		
		n22.setNext(n23);
		n23.setNext(n24);
		n24.setNext(n25);
		n25.setNext(n26);
		
		//System.out.println(SortedUpList(n22)); 
//---- seif3 
		System.out.println(SumDistInList(n22,6)); 
//---- seif4
		System.out.println(IfAllDifferentInList(n22)); 
//---- seif5
		System.out.println(ListWithoutDup(n22)); 
//---- seif6
		Node <Integer> n30 = new Node<Integer> (8);
		Node <Integer> n31 = new Node<Integer> (8);
		Node <Integer> n32 = new Node<Integer> (9);
		Node <Integer> n33 = new Node<Integer> (1);
		Node <Integer> n34 = new Node<Integer> (2);
		Node <Integer> n35 = new Node<Integer> (4);
		Node <Integer> n36 = new Node<Integer> (5);
		
		
		n30.setNext(n31);
		n31.setNext(n32);
		n32.setNext(n33);
		n33.setNext(n34);
		n34.setNext(n35);
		n35.setNext(n36);
		System.out.println(BiggestUpS(n30));
//---- seif7
		PrintBiggestUpS(n30);
		
		int[] arr = new int[]{1, 2, 3};
		Node <Integer> L1;
		L1 = arrToList(arr);
		
		int[] arr2 = new int[]{0, 2, 3, 1, 2, 3};
		Node <Integer> L2;
		L2 = arrToList(arr2);
		
//		System.out.println(ifL1IsInAllL2(L1,L2));

	 int[] arr = new int[]{1, 2, 3,3};
		 Node<Integer> n1 = arrToList(arr);
		 System.out.println(prodIfThereAreNoDuplicatesInNode(n1)); //סיבוכיות O(n**2)
}
 
	public static boolean prodIfThereAreNoDuplicatesInNode(Node<Integer> h) {
		if (h==null)
			return true;
		if (countNumInNode(h, h.getValue())>1) 
			return false;
			
		return prodIfThereAreNoDuplicatesInNode(h.getNext());
	}
	public static int countNumInNode(Node<Integer> h, int num) {
		Node<Integer> p1 = h;
		int count=0;
		while(p1!=null) {
			if (p1.getValue()==num)
				count++;
			p1 = p1.getNext();
		}
		return count;
	}

	public static Node<Integer> arrToList(int a[]) {
		Node<Integer> first = new Node<Integer> (a[0]);
		Node<Integer> prev;
		prev = first;
		Node<Integer> p;
		
		for (int i=1; i<a.length; i++) {
			p = new Node<Integer> (a[i]);
			prev.setNext(p);
			prev = p;
			
		}
		return first;
	}
	
	public static Node<Integer> newUpList(Node<Integer> L1,Node<Integer> L2) {
		Node<Integer> p1 = L1;
		Node<Integer> p2 = L2;
		Node<Integer> newH = new Node<Integer>(-1);
		Node<Integer> current = newH;

			while (p1!=null && p2!=null) {
				   
				if (p1.getValue()>p2.getValue()) {
					current.setNext(new Node<>(p2.getValue()));
		            p2 = p2.getNext();
				}
					
				else if (p2.getValue()>p1.getValue()) {
					current.setNext(new Node<>(p1.getValue()));
					p1 = p1.getNext();
				}
				else //(p2.getValue()==p1.getValue()) 
					{
					current.setNext(new Node<>(p1.getValue()));
		            current = current.getNext();
		            current.setNext(new Node<>(p1.getValue()));
					p2 = p2.getNext();
					p1 = p1.getNext();
				}
				current = current.getNext();
 
				}
			
			 while (p1 != null) {
			        current.setNext(new Node<>(p1.getValue()));
			        p1 = p1.getNext();
			        current = current.getNext();
			    }

			    while (p2 != null) {
			        current.setNext(new Node<>(p2.getValue()));
			        p2 = p2.getNext();
			        current = current.getNext();
			    }		
		
			
			return newH.getNext();
				
		}
	
	public static Node<Integer> SortedUpList(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		Node<Integer> newH = new Node<Integer>(-1);
		Node<Integer> current = newH;
		int min;
		
		while (p1!=null) {
			min = FindMinInList(p1);
			current.setNext(new Node<>(min));
			current = current.getNext();
			p1 = delList(p1,min);
		}
		return newH.getNext();
		
	}
	
	public static int FindMinInList(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		int min = p1.getValue();
		p1 = p1.getNext();
		
		while (p1!=null) {
			if (p1.getValue()<min)
				min=p1.getValue();
			p1 = p1.getNext();
		}
		
		
		return min;
	}
	
	public static Node<Integer> delList(Node<Integer> h, int x) {
		Node<Integer> p = new Node<Integer>(-1,h);
		h=p;
		Node<Integer> t;

		
		while (p.hasNext()) {
			if (p.getNext().getValue()==x){
				t=p.getNext();
				p.setNext(p.getNext().getNext());
				t.setNext(null);
				return h.getNext();
			}
			p=p.getNext();
			}
		return h.getNext();			
		}
	
	public static int SumDistInList(Node<Integer> L1, int num) {
		Node<Integer> p1 = L1;
		int startIndex=-1;
		int endIndex=-1;
		int i=0;
		int sumDist;
		int endDist;
		
		while (p1!=null) {
			if (p1.getValue()==num) {
				if (startIndex==-1)
					startIndex=i;
				else
					endIndex=i;
			}
			i++;
			p1 = p1.getNext();
		}
		if (startIndex==-1)
			return -1;
		if (endIndex==-1) {
			endDist=i-startIndex-1;
			sumDist=endDist+startIndex;
		}
		else {
			endDist=i-endIndex-1;
			sumDist=endDist+startIndex;
		}
		return sumDist;
	}
	public static boolean IfAllDifferentInList(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		Node<Integer> p2;
		
		while (p1!=null) {
			p2 = p1.getNext();
			while (p2!=null) {
				if (p1.getValue()==p2.getValue())
					return false;
				p2 = p2.getNext();
			}
			
			p1 = p1.getNext();
		}
		return true;
	} 
	public static Node<Integer> ListWithoutDup(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		Node<Integer> p2;
		Node<Integer> newH = new Node<Integer>(-1);
		Node<Integer> current = newH;
		int count = 0;
		
		while (p1!=null) {
			p2 = p1.getNext();
			count=0;
			while (p2!=null) {
				if (p1.getValue()==p2.getValue())
					count++;
				p2 = p2.getNext();
			}
			if (count==0) {
				current.setNext(new Node<>(p1.getValue()));
				current = current.getNext();
			}
			
			p1 = p1.getNext();
		}
		return newH.getNext();
		
	}
	public static int BiggestUpS(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		
		int last = p1.getValue();
		p1 = p1.getNext();
		int current;
		int maxLen = 1;
		int count=1;
		
		while (p1!=null) {
			current = p1.getValue();
			
			if (last<=current)
				count++;
			else {
				if (count>maxLen) {
					maxLen=count;
					count = 1;
				}
			}
			p1 = p1.getNext();
			last = current;
		}
		if (count>maxLen) {
			maxLen=count;
		}
		return maxLen;
	} 
	public static void PrintBiggestUpS(Node<Integer> L1) {
		Node<Integer> p1 = L1;
		Node<Integer> newL = new Node<Integer>(-1);
		Node<Integer> currentL = newL;
		Node<Integer> newLMax = new Node<Integer>(-1);
		
		int last = p1.getValue();
		p1 = p1.getNext();
		int current;
		int maxLen = 1;
		int count=1;
		
		while (p1!=null) {
			current = p1.getValue();
			
		if (last<=current) {
				count++;
				currentL.setNext(new Node<>(last));
				currentL = currentL.getNext();
			}
			else {
				if (count>maxLen) {
					maxLen=count;
					newLMax = newL;
					count = 1;
					currentL = new Node<Integer>(-1);
					newL = currentL;
				}
			}
			p1 = p1.getNext();
			last = current;
		}
		if (count>maxLen) {
			newLMax = newL;
			currentL.setNext(new Node<>(last));
			currentL = currentL.getNext();
		}
		System.out.println(newLMax.getNext());
	}
	
//	public static boolean ifL1IsInAllL2(Node<Integer> L1, Node<Integer> L2) {
//		Node<Integer> p1 = L1;
//		Node<Integer> p2 = L2;
//		boolean flag = true;
//		
//		while(p2!=null) {
//			while (p1!=null) {
//				
//				p1= p1.getNext();
//			}
//			
//			p2 = p2.getNext();
//		}
//		
//	}
	


}
