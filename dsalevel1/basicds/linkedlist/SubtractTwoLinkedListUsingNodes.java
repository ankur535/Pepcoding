package dsalevel1.basicds.linkedlist;

import java.io.*;

public class SubtractTwoLinkedListUsingNodes {
	public static class Node {
		int data;
		Node next;
	}

	public static class LinkedList {
		Node head;
		Node tail;
		int size;

		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;

			if (size == 0) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}

			size++;
		}

		public int size() {
			return size;
		}

		public void display() {
			for (Node temp = head; temp != null; temp = temp.next) {
				System.out.print(temp.data + " ");
			}
			System.out.println();
		}

		public void removeFirst() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				head = head.next;
				size--;
			}
		}

		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return head.data;
			}
		}

		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return tail.data;
			}
		}

		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}

		public void addFirst(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = head;
			head = temp;

			if (size == 0) {
				tail = temp;
			}

			size++;
		}

		public void addAt(int idx, int val) {
			if (idx < 0 || idx > size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				addFirst(val);
			} else if (idx == size) {
				addLast(val);
			} else {
				Node node = new Node();
				node.data = val;

				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}
				node.next = temp.next;

				temp.next = node;
				size++;
			}
		}

		public void removeLast() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				Node temp = head;
				for (int i = 0; i < size - 2; i++) {
					temp = temp.next;
				}

				tail = temp;
				tail.next = null;
				size--;
			}
		}

		public void removeAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				removeFirst();
			} else if (idx == size - 1) {
				removeLast();
			} else {
				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}

				temp.next = temp.next.next;
				size--;
			}
		}

		private Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public void reverseDI() {
			int li = 0;
			int ri = size - 1;
			while (li < ri) {
				Node left = getNodeAt(li);
				Node right = getNodeAt(ri);

				int temp = left.data;
				left.data = right.data;
				right.data = temp;

				li++;
				ri--;
			}
		}

		public void reversePI() {
			if (size <= 1) {
				return;
			}

			Node prev = null;
			Node curr = head;
			while (curr != null) {
				Node next = curr.next;

				curr.next = prev;
				prev = curr;
				curr = next;
			}

			Node temp = head;
			head = tail;
			tail = temp;
		}

		public int kthFromLast(int k) {
			Node slow = head;
			Node fast = head;
			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}

			while (fast != tail) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow.data;
		}

		public int mid() {
			Node f = head;
			Node s = head;

			while (f.next != null && f.next.next != null) {
				f = f.next.next;
				s = s.next;
			}

			return s.data;
		}

		public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
			LinkedList ml = new LinkedList();

			Node one = l1.head;
			Node two = l2.head;
			while (one != null && two != null) {
				if (one.data < two.data) {
					ml.addLast(one.data);
					one = one.next;
				} else {
					ml.addLast(two.data);
					two = two.next;
				}
			}

			while (one != null) {
				ml.addLast(one.data);
				one = one.next;
			}

			while (two != null) {
				ml.addLast(two.data);
				two = two.next;
			}

			return ml;
		}

		public static Node midNode(Node head, Node tail) {
			Node f = head;
			Node s = head;

			while (f != tail && f.next != tail) {
				f = f.next.next;
				s = s.next;
			}

			return s;
		}

		public static LinkedList mergeSort(Node head, Node tail) {
			if (head == tail) {
				LinkedList br = new LinkedList();
				br.addLast(head.data);
				return br;
			}

			Node mid = midNode(head, tail);
			LinkedList fsh = mergeSort(head, mid);
			LinkedList ssh = mergeSort(mid.next, tail);
			LinkedList sl = mergeTwoSortedLists(fsh, ssh);
			return sl;
		}

		public void removeDuplicates() {
			LinkedList res = new LinkedList();

			while (this.size() > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (res.size() == 0 || val != res.tail.data) {
					res.addLast(val);
				}
			}

			this.head = res.head;
			this.tail = res.tail;
			this.size = res.size;
		}

		public void oddEven() {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (val % 2 == 0) {
					even.addLast(val);
				} else {
					odd.addLast(val);
				}
			}

			if (odd.size > 0 && even.size > 0) {
				odd.tail.next = even.head;

				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			} else if (odd.size > 0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			} else if (even.size > 0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}

		public void kReverse(int k) {
			LinkedList prev = null;

			while (this.size > 0) {
				LinkedList curr = new LinkedList();

				if (this.size >= k) {
					for (int i = 0; i < k; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addFirst(val);
					}
				} else {
					int sz = this.size;
					for (int i = 0; i < sz; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addLast(val);
					}
				}

				if (prev == null) {
					prev = curr;
				} else {
					prev.tail.next = curr.head;
					prev.tail = curr.tail;
					prev.size += curr.size;
				}
			}

			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}

		private void displayReverseHelper(Node node) {
			if (node == null) {
				return;
			}
			displayReverseHelper(node.next);
			System.out.print(node.data + " ");
		}

		public void displayReverse() {
			displayReverseHelper(head);
			System.out.println();
		}

		private void reversePRHelper(Node node) {
			if (node == tail) {
				return;
			}
			reversePRHelper(node.next);
			node.next.next = node;
		}

		public void reversePR() {
			reversePRHelper(head);
			Node temp = head;
			head = tail;
			tail = temp;
			tail.next = null;
		}

		public static void displayUsingNode(Node node) {
			
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			System.out.println();
		}
		
		public static int getSize(Node node) {

			int size = 0;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}

		public static Node paddZero(Node small, int size) {

			if (small == null || size == 0) {
				return null;
			}

			Node nhead = new Node();
			nhead.data = 0;
			Node temp = nhead;
			size--;

			if (size > 0) {
				Node t = new Node();
				temp.next = t;
				temp = temp.next;
				size--;
			}
			temp.next = small;
			return nhead;
		}

		public static boolean subtractHelper(Node node1, Node node2) {

			if (node1 == null && node2 == null) {
				// means no borrow
				return false;
			}

			boolean borrow = false;
			borrow = subtractHelper(node1.next, node2.next);

			int val1 = node1.data;
			int val2 = node2.data;
			
			//if borrow reduce val1
			if (borrow) {
				val1--;
				borrow = false;
			}

			if (val1 < val2) {
				val1 = 10 + val1;
				borrow = true;
			}

			int diff = val1 - val2;

			Node temp = new Node();
			temp.data = diff;
			temp.next = diffNode;
			
			diffNode = temp;
			
			return borrow;
		}

		static Node diffNode;

		public static void subtractTwoLists(Node one, Node two) {
			// write your code here
			// finding larger and smaller node
			Node temp1 = one;
			Node temp2 = two;

			Node large = null;
			Node small = null;

			int size1 = getSize(one);
			int size2 = getSize(two);

			if (size1 != size2) {
				large = size1 > size2 ? one : two;
				small = size1 > size2 ? two : one;
				small = paddZero(small, Math.abs(size1 - size2));
			} else {
				while (temp1 != null && temp2 != null) {
					if (temp1.data != temp2.data) {
						large = temp1.data > temp2.data ? one : two;
						small = temp1.data > temp2.data ? two : one;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
			}
			// if no larger and smaller, than nodes data is equal so put diff as 0
			if (large == null && small == null) {
				Node node = new Node();
				node.data = 0;
				diffNode = node;
				return;
			}

			subtractHelper(large, small);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n1 = Integer.parseInt(br.readLine());
		LinkedList l1 = new LinkedList();
		String[] values1 = br.readLine().split(" ");
		for (int i = 0; i < n1; i++) {
			int d = Integer.parseInt(values1[i]);
			l1.addLast(d);
		}

		int n2 = Integer.parseInt(br.readLine());
		LinkedList l2 = new LinkedList();
		String[] values2 = br.readLine().split(" ");
		for (int i = 0; i < n2; i++) {
			int d = Integer.parseInt(values2[i]);
			l2.addLast(d);
		}
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		LinkedList.subtractTwoLists(l1.head, l2.head);

		l1.display();
		l2.display();
		LinkedList.displayUsingNode(LinkedList.diffNode);
		
		Node node1 = new Node();
		node1.data = a;
		node1.next = LinkedList.diffNode;
		
		Node node2 = new Node();
		node2.data = b;
		Node temp = LinkedList.diffNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node2;
		LinkedList.displayUsingNode(node1);
	}
}
